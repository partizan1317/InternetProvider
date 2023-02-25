package com.epam.internetprovider.service;

import com.epam.internetprovider.dao.DaoHelper;
import com.epam.internetprovider.dao.DaoHelperFactory;
import com.epam.internetprovider.dao.UserDao;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final DaoHelperFactory daoHelperFactory;

    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<User> login(String login, String password) throws Exception  {
        try(DaoHelper helper = daoHelperFactory.create()){
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            Optional<User> user = dao.findUserByLoginAndPassword(login, password);
            helper.endTransaction();
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void topUp(Long id, BigDecimal amount) throws Exception  {
        try(DaoHelper helper = daoHelperFactory.create()){
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            dao.topUpBalance(id, amount);
            helper.endTransaction();
        } catch (DaoException e) { 
            throw new ServiceException(e);
        }
    }

    public void changePersonalData(String name, String surname, Long id) throws Exception  {
        try(DaoHelper helper = daoHelperFactory.create()){
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            dao.changePersonalData(id, name, surname);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void changeUserTariff(Long tariffId, Long userId) throws Exception {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            dao.changeUserTariff(tariffId, userId);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<User> getById(Long id) throws Exception {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            Optional<User> user = dao.getById(id);
            helper.endTransaction();
            return user;
        }
    }

    public List<User> getAll() throws Exception {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            List<User> users = dao.getAll();
            helper.endTransaction();
            return users;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void updateUserBlockedStatus(Long id, Boolean blockedStatus) throws Exception {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            dao.updateUserBlockedStatus(id, blockedStatus);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void registerUser(String login,String password, String name, String surname) throws Exception {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            dao.registerUser(login, password, name, surname);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
