package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.service.TariffServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommandAdminTariffsPage implements Command{

    private final TariffServiceImpl service;

    public CommandAdminTariffsPage(TariffServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Tariff> tariffs = service.getAll();
        request.setAttribute("tariffs", tariffs);
        return CommandResult.forward("/WEB-INF/pages/admin-tariffs-page.jsp");
    }
}
