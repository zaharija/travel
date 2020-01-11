package com.veleri.dao;

import com.veleri.dao.interfaces.UserDao;
import com.veleri.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("user")
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<User> getAllUsers() {
        String userSql = "SELECT * FROM users;";
        return jdbcTemplate.query(userSql, (resultSet, rowNumber) -> new User(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("token")
                )
        );
    }

    @Override
    public User getUserById(int id) {
        String userSql = "SELECT * FROM users WHERE id = ?;";
        return jdbcTemplate.queryForObject(userSql, new Object[]{id}, (resultSet, rowNumber) -> new User(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("token")
                )
        );
    }

    @Override
    public void removeUserById(int id) {
        try {
            String userSql = "DELETE FROM users WHERE id = ?;";
            jdbcTemplate.update(userSql, id);
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            String userSql = "UPDATE users SET full_name = ?, email = ?, password = ?, phone_number = ?, token = ? WHERE id = ?;";
            jdbcTemplate.update(userSql, new Object[]{
                    user.getFullName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getPhoneNumber(),
                    user.getToken()
            }, user.getId());
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void insertUserToDb(User user) {
        try {
            String userSql = "INSERT INTO users (full_name, email, password, phone_number, token) VALUES (?, ?, ?, ?, ?);";
            jdbcTemplate.update(userSql, new Object[]{
                    user.getFullName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getPhoneNumber(),
                    user.getToken()
            });
        } catch(Exception e) {
            throw e;
        }
    }
}
