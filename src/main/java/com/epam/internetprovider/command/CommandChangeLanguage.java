package com.epam.internetprovider.command;

import com.epam.internetprovider.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class CommandChangeLanguage implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, UnsupportedEncodingException {
        String language = request.getParameter("locale");
        if (Objects.equals(language, "en_US")) {
            request.getSession().setAttribute("locale","en");
        } else if (Objects.equals(language, "ru_RU")) {
            request.getSession().setAttribute("locale", "ru");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        }
        return CommandResult.forward("/main-user-page.jsp");
    }
}
