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
        User user = (User) request.getSession().getAttribute("user");
        BigDecimal balance = user.getAmount();
        String amountToTopUp = request.getParameter("amount");
        double amountToConvert = Double.parseDouble(amountToTopUp);
        BigDecimal convertedAmountToTopUp = BigDecimal.valueOf(amountToConvert);
        BigDecimal updatedBalance = balance.add(convertedAmountToTopUp);
        user.setAmount(updatedBalance);
        service.topUp(user);
        return CommandResult.forward("/WEB-INF/pages/refill-page.jsp");
    }
}
