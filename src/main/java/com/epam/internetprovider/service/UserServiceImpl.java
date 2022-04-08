package com.epam.internetprovider.service;

import com.epam.internetprovider.dao.DaoHelper;
import com.epam.internetprovider.dao.DaoHelperFactory;
import com.epam.internetprovider.dao.UserDao;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.exception.ServiceException;

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

    public void topUp(User user) throws Exception  {
        try(DaoHelper helper = daoHelperFactory.create()){
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            dao.topUpBalance(user);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void changeName(User user) throws Exception  {
        try(DaoHelper helper = daoHelperFactory.create()){
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            dao.changeName(user);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
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
}
