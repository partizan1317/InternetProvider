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
            Long userId = user.getId();
            CommandResult result;
            if (!name.isEmpty() && !surname.isEmpty()) {
                user.setName(name);
                user.setSurname(surname);
                service.changePersonalData(name, surname, userId);
                result = CommandResult.forward("/WEB-INF/pages/profile-page.jsp");
            }
            else {
                request.setAttribute("errorMessage", "Error: fields can not be empty");
                result = CommandResult.forward("/WEB-INF/pages/error-page.jsp");
            }
            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
