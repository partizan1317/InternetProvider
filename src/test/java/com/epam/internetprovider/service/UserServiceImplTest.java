package com.epam.internetprovider.service;

import com.epam.internetprovider.connection.ConnectionPool;
import com.epam.internetprovider.dao.DaoHelper;
import com.epam.internetprovider.dao.DaoHelperFactory;
import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserServiceImplTest {

//    private final DaoHelper daoHelper = new DaoHelper(ConnectionPool.getInstance());
//    private final Optional<User> expectedUser = Optional.of((new User(1L,"Evgeniy","Sobol", "admin", new BigDecimal("0.00"),true, false, Tariff.byId(2L))));
//    private static final String correctLogin = "admin";
//    private static final String correctPassword = "admin";
//    private final Optional<User> expectedEmptyUser = Optional.empty();
//    private static final String inCorrectLogin = "neAdmin";
//    private static final String inCorrectPassword = "neAdmin";
//    private static final List<User> expectedUsers = Arrays.asList(new User(1L,"Evgeniy","Sobol", "admin", new BigDecimal("0.00"),true, false, Tariff.byId(2L)),
//            new User(2L,"Marina","Nurk", "partizan", new BigDecimal("100.00"),false, false, Tariff.byId(3L)),
//            new User(3L,"Anton","Karas", "miracle", new BigDecimal("0.00"),false, true, Tariff.byId(2L)));
//    @Test
//    public void testLoginShouldFindUserFromDatabaseByCorrectLoginAndPassword() throws Exception {
//        DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
//        Mockito.when(daoHelperFactory.create()).thenReturn(daoHelper);
//        UserServiceImpl service = new UserServiceImpl(daoHelperFactory);
//        Optional<User> actualUser = service.login(correctLogin, correctPassword);
//        Assert.assertEquals(expectedUser,actualUser);
//    }
//
//    @Test
//    public void testLoginShouldReturnAnEmptyContainerIfLoginIsNotValid() throws Exception {
//        DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
//        Mockito.when(daoHelperFactory.create()).thenReturn(daoHelper);
//        UserServiceImpl service = new UserServiceImpl(daoHelperFactory);
//        Optional<User> actualUser = service.login(inCorrectLogin, correctPassword);
//        Assert.assertEquals(expectedEmptyUser,actualUser);
//    }
//
//    @Test
//    public void testLoginShouldReturnAnEmptyContainerIfPasswordIsNotValid() throws Exception {
//        DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
//        Mockito.when(daoHelperFactory.create()).thenReturn(daoHelper);
//        UserServiceImpl service = new UserServiceImpl(daoHelperFactory);
//        Optional<User> actualUser = service.login(correctLogin, inCorrectPassword);
//        Assert.assertEquals(expectedEmptyUser,actualUser);
//    }
//
//    @Test
//    public void testGetAllShouldReturnAllUsersFromDatabase() throws Exception {
//        DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
//        Mockito.when(daoHelperFactory.create()).thenReturn(daoHelper);
//        UserServiceImpl service = new UserServiceImpl(daoHelperFactory);
//        List<User> actualUsers = service.getAll();
//        Assert.assertEquals(expectedUsers,actualUsers);
//    }

}
