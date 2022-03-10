package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.ServiceException;
import com.epam.internetprovider.service.SimpleUserService;
import com.epam.internetprovider.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class CommandLogin implements Command {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private final UserServiceImpl service;

    public CommandLogin(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String login = request.getParameter(PARAM_NAME_LOGIN);
            String password = request.getParameter(PARAM_NAME_PASSWORD);
            Optional<User> user = service.login(login, password);
            CommandResult result;
            if (user.isPresent()) {
                request.getSession().setAttribute("user", user.get());
                request.getSession().setAttribute("isLoggedIn", true);
                result = CommandResult.forward("/WEB-INF/pages/main-user-page.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid login or password");
                result = CommandResult.forward("/login-page.jsp");
            }
            return result;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
