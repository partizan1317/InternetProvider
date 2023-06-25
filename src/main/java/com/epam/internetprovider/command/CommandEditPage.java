package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandEditPage implements Command{
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            User user = (User) request.getSession().getAttribute("user");
            CommandResult result;
            if (user != null) {
                request.setAttribute("userName", user.getName());
                request.setAttribute("userSurname", user.getSurname());
                result = CommandResult.forward("/WEB-INF/pages/edit-user-page.jsp");
            } else {
                request.setAttribute("errorMessage", "Tariff not found");
                result = CommandResult.forward("/WEB-INF/pages/error-page.jsp");
            }
            return result;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
