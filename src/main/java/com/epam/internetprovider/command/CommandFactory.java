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

    public static Command create(String command){
        switch(command) {
            case "login":
                return new CommandLogin(new UserServiceImpl(new DaoHelperFactory()));
            case "logout":
                return new CommandLogout();
            case "language-change":
                return new CommandChangeLanguage();
            case "main-page":
                return new CommandMainPage();
            case "login-page":
                return new CommandLoginPage();
            case "refill-page":
                return new CommandRefillPage();
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}
