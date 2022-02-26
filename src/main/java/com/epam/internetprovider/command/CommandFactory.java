package com.epam.internetprovider.command;

import com.epam.internetprovider.dao.SimpleUserDao;
import com.epam.internetprovider.dao.UserDaoImpl;
import com.epam.internetprovider.service.SimpleUserService;

import java.sql.Connection;

public class CommandFactory {

    public static Command create(String command) {
        switch(command) {
            case "login":
                return new LoginCommand(new SimpleUserService(new SimpleUserDao()));
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}
