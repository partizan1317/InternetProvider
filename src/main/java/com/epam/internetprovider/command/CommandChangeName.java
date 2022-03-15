package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandChangeName implements Command {

    private final UserServiceImpl service;

    public CommandChangeName(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        user.setName("Pavel");
        service.changeName(user);
        return CommandResult.forward("/WEB-INF/pages/profile-page.jsp");
    }
}
