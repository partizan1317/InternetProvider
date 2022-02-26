package com.epam.internetprovider.service;

import com.epam.internetprovider.dao.SimpleUserDao;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.exception.ServiceException;

import java.util.Optional;

public class SimpleUserService implements UserService {

    private final SimpleUserDao dao;

    public SimpleUserService(SimpleUserDao dao) {
        this.dao = dao;
    }

    public Optional<User> login(String login, String password) throws ServiceException {
        try {
            Optional<User> user = dao.findUserByLoginAndPassword(login, password);
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
