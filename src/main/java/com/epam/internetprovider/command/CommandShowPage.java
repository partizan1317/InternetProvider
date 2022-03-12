package com.epam.internetprovider.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandShowPage implements Command {

    private final String page;

    public CommandShowPage(String page) {
        this.page = page;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response){
        return CommandResult.forward(page);
    }
}
