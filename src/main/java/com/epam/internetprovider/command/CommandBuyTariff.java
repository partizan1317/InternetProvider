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
            long tariffId = Long.parseLong(request.getParameter("tariffId"));
            Optional<Tariff> tariffs = tariffService.getById(tariffId);
            if (tariffs.isPresent()) {
                Tariff tariff = tariffs.get();
                user.setTariff(tariff);
                BigDecimal tariffPrice = tariff.getPrice();
                BigDecimal userAmount = user.getAmount();
                BigDecimal updatedUserAmount = userAmount.subtract(tariffPrice);
                user.setAmount(updatedUserAmount);
            }
            userService.changeUserTariff(user);
            List<Tariff> allTariffs = tariffService.getAll();
            request.setAttribute("tariffs", allTariffs);
            return CommandResult.forward("/WEB-INF/pages/tariffs-page.jsp");
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
