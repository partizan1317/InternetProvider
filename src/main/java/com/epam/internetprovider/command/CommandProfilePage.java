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
            CommandResult result;
            if (tariff.isPresent()) {
                request.setAttribute("tariff", tariff.get());
                result = CommandResult.forward("/WEB-INF/pages/profile-page.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid login or password");
                result = CommandResult.forward("/login-page.jsp");
            }
            return result;
        }
        catch (Exception e) {
            throw new Exception(e);
        }
    }
}
