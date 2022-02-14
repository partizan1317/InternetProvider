package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.ServiceException;
import com.epam.internetprovider.service.SimpleUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {

    private SimpleUserService service;

    public LoginCommand(SimpleUserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Optional<User> user = service.login(login, password);
        CommandResult result;
        if (user.isPresent()) {
            request.getSession().setAttribute("user", user.get());
            result = CommandResult.redirect("controller?command=mainPage");
        } else {
            request.setAttribute("errorMessage", "Invalid login or password");
            result = CommandResult.forward("/index.jsp");
        }
        return result;
    }
}
