package com.epam.internetprovider.command;

import com.epam.internetprovider.dao.DaoHelperFactory;
import com.epam.internetprovider.dao.SimpleUserDao;
import com.epam.internetprovider.dao.UserDaoImpl;
import com.epam.internetprovider.service.SimpleUserService;
import com.epam.internetprovider.service.UserServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class CommandFactory {

    private static final String MAIN_USER_PAGE = "/WEB-INF/pages/main-user-page.jsp";
    private static final String REFILL_PAGE = "/WEB-INF/pages/refill-page.jsp";
    private static final String LOGIN_PAGE = "/login-page.jsp";

    public static Command create(String command){
        switch(command) {
            case "login":
                return new CommandLogin(new UserServiceImpl(new DaoHelperFactory()));
            case "logout":
                return new CommandLogout();
            case "language-change":
                return new CommandChangeLanguage();
            case "main-page":
                return new CommandShowPage(MAIN_USER_PAGE);
            case "login-page":
                return new CommandShowPage(LOGIN_PAGE);
            case "refill-page":
                return new CommandShowPage(REFILL_PAGE);
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}
