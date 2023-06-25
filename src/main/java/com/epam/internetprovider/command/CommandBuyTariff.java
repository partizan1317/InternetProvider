package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.service.TariffServiceImpl;
import com.epam.internetprovider.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class CommandBuyTariff implements Command {

    private final UserServiceImpl userService;
    private final TariffServiceImpl tariffService;

    public CommandBuyTariff (UserServiceImpl userService, TariffServiceImpl tariffService){
        this.userService = userService;
        this.tariffService = tariffService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            User user = (User) request.getSession().getAttribute("user");
            Long tariffId = Long.parseLong(request.getParameter("tariffId"));
            Optional<Tariff> tariffs = tariffService.getById(tariffId);
            Long userId = user.getId();
            CommandResult result;
            if (tariffs.isPresent()) {
                Tariff tariff = tariffs.get();
                user.setTariff(tariff);
                BigDecimal tariffPrice = tariff.getPrice();
                BigDecimal userAmount = user.getAmount();
                if (userAmount.floatValue() > tariffPrice.floatValue()) {
                    BigDecimal updatedUserAmount = userAmount.subtract(tariffPrice);
                    user.setAmount(updatedUserAmount);
                    userService.topUp(userId, updatedUserAmount);
                    result = CommandResult.forward("/WEB-INF/pages/tariffs-page.jsp");
                }
                else {
                    request.setAttribute("errorMessage", "Not enough money");
                    result = CommandResult.forward("/WEB-INF/pages/error-page.jsp");
                }
            }
            else {
                request.setAttribute("errorMessage", "Selected tariff is not present");
                result = CommandResult.forward("/WEB-INF/pages/error-page.jsp");
            }
            userService.changeUserTariff(tariffId, userId);
            List<Tariff> allTariffs = tariffService.getAll();
            request.setAttribute("tariffs", allTariffs);
            return result;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
