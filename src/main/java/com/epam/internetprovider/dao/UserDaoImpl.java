package com.epam.internetprovider.dao;

import com.epam.internetprovider.entity.User;
import com.epam.internetprovider.exception.DaoException;
import com.epam.internetprovider.mapper.UserRowMapper;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.*;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM USER WHERE" +
            " LOGIN = ? AND PASSWORD = ?";
    private static final String FIND_BY_ID = "SELECT * FROM USER WHERE id = ?";
    private static final String UPDATE_USER_BALANCE = "UPDATE user SET amount = ? WHERE id = ?";
    private static final String CHANGE_USER_TARIFF = "UPDATE user SET tariff_id = ? WHERE id = ?";
    private static final String CHANGE_USER_PERSONAL_DATA = "UPDATE user SET name = ?, surname = ? WHERE id = ?";
    private static final String CHANGE_USER_BLOCKED_STATUS = "UPDATE user SET is_blocked = ? WHERE id = ?";
    private static final String REGISTER_USER = "insert into user (name, surname, login, password, is_admin, amount, is_blocked) values(?, ?, ?, ?, false, 0.00, false)";

    public UserDaoImpl(Connection connection) {
        super(connection, new UserRowMapper(), User.TABLE);
    }

    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    public void topUpBalance(Long id, BigDecimal amount) throws DaoException {
        executeUpdate(UPDATE_USER_BALANCE, amount, id);
    }

    public void changePersonalData(Long id,  String name, String surname) throws DaoException {
        executeUpdate(CHANGE_USER_PERSONAL_DATA, name, surname, id);
    }

    public void updateUserBlockedStatus (Long id, Boolean status) throws DaoException {
        executeUpdate(CHANGE_USER_BLOCKED_STATUS, status, id);
    }

    public void registerUser (String login, String password, String name, String surname) throws DaoException {
        executeUpdate(REGISTER_USER, name, surname, login, password);
    }

    @Override
    public void changeUserTariff(Long tariffId, Long userId) throws DaoException {
        executeUpdate(CHANGE_USER_TARIFF, tariffId, userId);
    }

    @Override
    public Optional<User> getById(Long id) throws DaoException {
        return executeForSingleResult(FIND_BY_ID, id);
    }

    @Override
    public List<User> getAll() throws DaoException {
        return executeQuery("select * from user");
        // return executeQuery("select * from user where " + spec.toSql(), new UserRowMapper());
    }

    @Override
    public void save(User user) throws DaoException {
        super.save(user);
    }

    @Override
    protected Map<String, Object> getFields(User item) {
        LinkedHashMap<String, Object> fields = new LinkedHashMap<>();
        fields.put(User.NAME, item.getName());
        fields.put(User.SURNAME, item.getSurname());
        fields.put(User.AMOUNT, item.getAmount());
        fields.put(User.TARIFF_ID, item.getTariff().getId());
        fields.put(User.IS_BLOCKED, item.isBlocked());
        return fields;
    }



    @Override
    public void removeById(Long id) {

    }

    protected String getTableName() {
        return User.TABLE;
    }

}
