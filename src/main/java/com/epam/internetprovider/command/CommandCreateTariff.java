package com.epam.internetprovider.command;

import com.epam.internetprovider.service.TariffServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandCreateTariff implements Command {

    private final TariffServiceImpl service;

    CommandCreateTariff(TariffServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}
