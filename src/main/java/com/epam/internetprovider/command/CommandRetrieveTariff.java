package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.service.TariffServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public class CommandRetrieveTariff implements Command{

    private final TariffServiceImpl service;

    public CommandRetrieveTariff(TariffServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            long tariffId = Long.parseLong(request.getParameter("tariffId"));
            Optional<Tariff> optionalTariff = service.getById(tariffId);
            CommandResult result;
            if (optionalTariff.isPresent()) {
                Tariff tariff = optionalTariff.get();
                tariff.setDeleted(false);
                service.updateDeletedStatus(tariffId, false);
                result = CommandResult.forward("/WEB-INF/pages/admin-tariffs-page.jsp");
            }
            else {
                request.setAttribute("errorMessage", "Tariff not exist");
                result = CommandResult.forward("/WEB-INF/pages/error-page.jsp");
            }
            List<Tariff> tariffs = service.getAll();
            request.setAttribute("tariffs", tariffs);
            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
