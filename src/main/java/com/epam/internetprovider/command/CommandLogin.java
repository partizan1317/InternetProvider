package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.service.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            if (login.isEmpty()) {
                request.setAttribute("errorMessage", "Login field can not be empty");
                return CommandResult.forward("/WEB-INF/pages/error-page.jsp");
            }
            else if (password.isEmpty()) {
                request.setAttribute("errorMessage", "Password field can not be empty");
                return CommandResult.forward("/WEB-INF/pages/error-page.jsp");
            }
            else {
                Optional<User> optionalUser = service.login(login, password);
                if (optionalUser.isPresent()) {
                    User user = optionalUser.get();
                    Boolean isAdmin = user.isAdmin();
                    boolean isBlocked = user.isBlocked();
                    if (isBlocked) {
                        request.setAttribute("errorMessage", "Your account was blocked by administrator. Please contact with support!");
                        return CommandResult.forward("/WEB-INF/pages/error-page.jsp");
                    }
                    else {
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        session.setAttribute("isLoggedIn", true);
                        session.setAttribute("isAdmin", isAdmin);
                        return Boolean.TRUE.equals(isAdmin) ? CommandResult.forward("/WEB-INF/pages/main-admin-page.jsp") :
                                CommandResult.forward("/WEB-INF/pages/main-user-page.jsp");
                    }
                }
                else {
                    request.setAttribute("errorMessage", "Invalid login or password");
                    return CommandResult.forward("/WEB-INF/pages/error-page.jsp");
                }
            }
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
