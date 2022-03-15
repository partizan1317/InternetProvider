package com.epam.internetprovider.servlet;

import com.epam.internetprovider.command.Command;
import com.epam.internetprovider.command.CommandFactory;
import com.epam.internetprovider.command.CommandResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = -7560675906704947226L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String command = request.getParameter("command");
        Command action = CommandFactory.create(command);
        try {
            CommandResult result = action.execute(request, response);
            dispatch(request, response, result);
        } catch (Exception e) {
            request.setAttribute("errorMessage", Arrays.toString(e.getStackTrace()));
            dispatch(request, response, CommandResult.forward("/WEB-INF/pages/error-page.jsp"));
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, CommandResult result) throws ServletException, IOException {
        String page = result.getPage();
        if (!result.isRedirect()) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(page);
        }
    }
}
