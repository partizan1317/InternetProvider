package com.epam.internetprovider.service;

import com.epam.internetprovider.dao.*;
import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.exception.ServiceException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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

    public List<Tariff> getAll() throws Exception {
        try (DaoHelper helper = daoHelperFactory.create()){
            helper.startTransaction();
            TariffDao dao = helper.createTariffDao();
            List<Tariff> tariffs = dao.getAll();
            helper.endTransaction();
            return tariffs;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void updateDeletedStatus (Long id, Boolean status) throws SQLException, IOException, ClassNotFoundException, ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            TariffDao dao = helper.createTariffDao();
            dao.updateDeletedStatus(id, status);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

}
