package com.epam.internetprovider.command;

import com.epam.internetprovider.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class CommandChangeLanguage implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, UnsupportedEncodingException {
        String language = request.getParameter("locale");
        HttpSession session = request.getSession();
        session.setAttribute("locale", language);
        return CommandResult.forward("/login-page.jsp");
    }
}
