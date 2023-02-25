package com.epam.internetprovider.command;

import com.epam.internetprovider.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandRegisterUser implements Command {

    private final UserServiceImpl service;

    public CommandRegisterUser(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        CommandResult result;
        try{
            if (!name.isEmpty() && !surname.isEmpty() && !login.isEmpty() && !password.isEmpty()) {
                service.registerUser(login, password, name, surname);
                result = CommandResult.forward("/WEB-INF/pages/main-admin-page.jsp");
            }
            else {
                request.setAttribute("errorMessage", "One or more fields were empty");
                result = CommandResult.forward("/WEB-INF/pages/error-page.jsp");
            }
            return result;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
