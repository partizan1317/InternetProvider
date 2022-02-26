package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.ServiceException;
import com.epam.internetprovider.service.SimpleUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    private final SimpleUserService service;

    public LoginCommand(SimpleUserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        Optional<User> user = service.login(login, password);
        CommandResult result;
        if (user.isPresent()) {
            request.getSession().setAttribute("user", user.get());
            request.getSession().setAttribute("isLoggedIn", true);
            result = CommandResult.forward("/main-user-page.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid login or password");
            result = CommandResult.forward("/login-page.jsp");
        }
        return result;
    }
}
