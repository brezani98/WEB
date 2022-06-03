package sk.kmikt.mvc.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import sk.kmikt.mvc.Database;
import sk.kmikt.mvc.models.User;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {


    public int insertUser(User user) throws SQLException, NamingException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO users (email, password, name) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getName());


        return preparedStatement.executeUpdate();
    }


    public User getUserById(int id_) throws SQLException, NamingException {
        User user = null;
        Connection connection = Database.getConnection();

        String sql = "SELECT * FROM users WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getBoolean("blocked")
            );
        }
        connection.close();
        return user;
    }


    public User loginUser(User user) throws SQLException, NamingException {
        String sql = "SELECT * FROM users WHERE email=?";
        Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getEmail());
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            if (result.getString("password") != null) {
                String hashFromDb = result.getString("password");
                if (BCrypt.verifyer().verify(
                        user.getPassword().toCharArray(),
                        hashFromDb
                ).verified || user.isBlocked()) {
                    User userResult = new User(
                            result.getInt("id"),
                            result.getString("email"),
                            "",
                            result.getString("name"),
                            result.getBoolean("blocked")
                    );
                    connection.close();
                    return userResult;
                } else {

                    // Password is not match -> wrong password
                    return null;
                }
            } else {
                return null;
            }
        }
        connection.close();
        return null;
    }

    public ArrayList<User> getAllUsers() throws SQLException, NamingException {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM users ORDER BY id DESC";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            users.add(new User(
                    resultSet.getInt("id"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getBoolean("blocked")
            ));
        }
        connection.close();
        return users;
    }

    public int deleteUserById(int id_) throws SQLException, NamingException {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM users WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_);
        return preparedStatement.executeUpdate();
    }

    public void blockUserById(int id_) throws SQLException, NamingException {
        String sql = "UPDATE users SET blocked = ? WHERE id = ?;";
        Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (getUserById(id_).isBlocked()) {
            preparedStatement.setBoolean(1, false);
        } else {
            preparedStatement.setBoolean(1, true);
        }
        preparedStatement.setInt(2, id_);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void updateUser(User user) throws SQLException, NamingException {
        String sql = "UPDATE users SET email = ?, password = ?, name = ? WHERE id = 1;";
        Connection connection = Database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getName());
        preparedStatement.executeUpdate();
        connection.close();
    }


}
