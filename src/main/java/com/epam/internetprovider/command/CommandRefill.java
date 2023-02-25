package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class CommandRefill implements Command{

    private final UserServiceImpl service;

    public CommandRefill(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            User user = (User) request.getSession().getAttribute("user");
            Long id = user.getId();
            BigDecimal balance = user.getAmount();
            String amountToTopUpLine = request.getParameter("amount");
            BigDecimal amountToTopUp = new BigDecimal(amountToTopUpLine);
            CommandResult result;
            if (amountToTopUp.signum() != -1 && amountToTopUp.floatValue() < 10000.00) {
                BigDecimal updatedBalance = balance.add(amountToTopUp);
                user.setAmount(updatedBalance);
                service.topUp(id, updatedBalance);
                result = CommandResult.forward("/WEB-INF/pages/refill-page.jsp");
            }
            else {
                request.setAttribute("errorMessage", "Invalid amount to top up! (It should be positive and not more than 10000.00)");
                result = CommandResult.forward("/WEB-INF/pages/error-page.jsp");
            }
            return result;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
