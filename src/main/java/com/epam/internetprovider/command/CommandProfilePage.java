package com.epam.internetprovider.command;

import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.service.TariffServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class CommandProfilePage implements Command{

    private final TariffServiceImpl service;

    public CommandProfilePage(TariffServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            User user = (User) request.getSession().getAttribute("user");
            Tariff userTariff = user.getTariff();
            Long tariffId = userTariff.getId();
            Optional<Tariff> tariff = service.getById(tariffId);
            if (tariff.isPresent()) {
                request.setAttribute("tariff", tariff.get());
            } else {
                request.setAttribute("tariff", null);
            }
            return CommandResult.forward("/WEB-INF/pages/profile-page.jsp");
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
