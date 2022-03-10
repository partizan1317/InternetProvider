package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "select * from user where login = ? and password = ?";

    public UserDaoImpl(Connection connection) {
        super(connection, new UserRowMapper());
    }

    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, login, password);
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
    protected Map<String, Object> getFields(User item) {
        Map<String, Object> fields = new HashMap<>();
        fields.put(User.NAME, null);//item.getName());;
        return fields;
    }

    @Override
    public void removeById(Long id) {

    }

    protected String getTableName() {
        //return User.TABLE;
        return "ZAEBALO";
    }

}
