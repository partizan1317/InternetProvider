package com.epam.internetprovider.service;

import com.epam.internetprovider.dao.*;
import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.exception.ServiceException;

import java.util.Optional;

public class TariffServiceImpl implements TariffService{

    private final DaoHelperFactory daoHelperFactory;

    public TariffServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<Tariff> getById(Long id) throws Exception {
        try(DaoHelper helper = daoHelperFactory.create()){
            helper.startTransaction();
            TariffDao dao = helper.createTariffDao();
            Optional<Tariff> tariff = dao.getById(id);
            helper.endTransaction();
            return tariff;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
