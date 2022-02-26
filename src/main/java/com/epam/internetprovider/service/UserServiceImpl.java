package com.epam.internetprovider.service;

import com.epam.internetprovider.dao.DaoHelper;
import com.epam.internetprovider.dao.DaoHelperFactory;
import com.epam.internetprovider.dao.UserDao;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.exception.ServiceException;

import java.util.Optional;

//public class UserServiceImpl implements UserService {

//    private DaoHelperFactory daoHelperFactory;
//
//    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
//        this.daoHelperFactory = daoHelperFactory;
//    }

//    public Optional<User> login(String login, String password) throws Exception {
//        try(DaoHelper helper = daoHelperFactory.create()){
//            helper.startTransaction();
//            UserDao dao = helper.createUserDao();
//            //Optional<User> user = dao.findUserByLoginAndPassword(login, password);
//            helper.endTransaction();
//            //return user;
//        } catch (DaoException e) {
//            throw  new ServiceException(e);
//        //}
//    //}
//
////}
