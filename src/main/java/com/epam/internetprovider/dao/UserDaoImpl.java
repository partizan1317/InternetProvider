package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "select * from user where login = ? and password = ?";

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, new UserRowMapper(), login, password);
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
        //Specification spec = new FindByIdSpecification(id);
        //return executeQuery("select * from user where " + spec.toSql(), new UserRowMapper());
    }

    @Override
    public List<User> getAll() throws DaoException {
        return executeQuery("select * from user", new UserRowMapper());
        // return executeQuery("select * from user where " + spec.toSql(), new UserRowMapper());
    }

    @Override
    public void save(User item){

    }

    @Override
    public void removeById(Long id) {

    }

    protected String getTableName() {
        return User.TABLE;
    }

}
