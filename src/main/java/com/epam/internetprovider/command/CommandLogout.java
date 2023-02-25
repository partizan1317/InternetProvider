package com.epam.internetprovider.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandLogout implements Command {

    private static final String LOGIN_PAGE = "/login-page.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        return CommandResult.forward(LOGIN_PAGE);
    }
}
