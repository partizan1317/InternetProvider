package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommandAdminUsersPage implements Command{

    private final UserServiceImpl service;

    public CommandAdminUsersPage(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> users = service.getAll();
        request.setAttribute("users", users);
        return CommandResult.forward("/WEB-INF/pages/admin-users-page.jsp");
    }
}
