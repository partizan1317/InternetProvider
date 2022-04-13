package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandChangePersonalData implements Command {

    private final UserServiceImpl service;

    public CommandChangePersonalData(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            User user = (User) request.getSession().getAttribute("user");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            if (!name.isEmpty() && !surname.isEmpty()) {
                user.setName(name);
                user.setSurname(surname);
                service.changePersonalData(user);
            }
            return CommandResult.forward("/WEB-INF/pages/profile-page.jsp");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
