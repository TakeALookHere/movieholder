package com.miskevich.movieholder.dao.jdbc;

import com.miskevich.movieholder.dao.IUserDao;
import com.miskevich.movieholder.dao.jdbc.mapper.UserRowMapper;
import com.miskevich.movieholder.dao.jdbc.util.ConnectionSource;
import com.miskevich.movieholder.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDao implements IUserDao {

    private static final String USER_BY_ID_SQL = "select id, nickname, email from user where id = ?";

    private static final UserRowMapper USER_ROW_MAPPER = new UserRowMapper();

    private DataSource dataSource;

    public JdbcUserDao() {
        dataSource = ConnectionSource.createConnectionSource();
    }

    @Override
    public User getById(int id) {
        User user = new User();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user = USER_ROW_MAPPER.map(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
