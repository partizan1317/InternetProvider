package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class CommandBlockUser implements Command{

    private final UserServiceImpl service;

    public CommandBlockUser(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            long userId = Long.parseLong(request.getParameter("userId"));
            Optional<User> optionalUser = service.getById(userId);
            CommandResult result;
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                user.setBlocked(true);
                service.updateUserBlockedStatus(userId, true);
                result = CommandResult.forward("/WEB-INF/pages/admin-users-page.jsp");
            }
            else {
                request.setAttribute("errorMessage", "User not exist");
                result = CommandResult.forward("/WEB-INF/pages/error-page.jsp");
            }
            List<User> users = service.getAll();
            request.setAttribute("users", users);
            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
