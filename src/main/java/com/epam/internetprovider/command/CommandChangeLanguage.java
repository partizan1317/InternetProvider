package com.epam.internetprovider.command;

import com.epam.internetprovider.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

public class CommandChangeLanguage implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, UnsupportedEncodingException {
        String language = request.getParameter("locale");
        HttpSession session = request.getSession();
        session.setAttribute("locale", language);
        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (isAdmin && isLoggedIn) {
            return CommandResult.forward("/WEB-INF/pages/main-admin-page.jsp");
        }
        else if (!isAdmin && isLoggedIn){
            return CommandResult.forward("/WEB-INF/pages/main-user-page.jsp");
        }
        else {
            return CommandResult.forward("/login-page.jsp");
        }
    }
}
