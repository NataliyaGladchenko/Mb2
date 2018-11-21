package repository;

import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {

    public List<Users> getAllUsers() throws SQLException, ClassNotFoundException {
        Connection connection = DataSource.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        List<Users> usersList = new ArrayList<Users>();
        while (resultSet.next()) {
            Users user = new Users(resultSet.getInt("user_id"), resultSet.getString("user_name"));
            usersList.add(user);
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return usersList;

    }

    public void addUser(String userName) throws SQLException, ClassNotFoundException {
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(user_name) VALUES (?)");
        preparedStatement.setString(1, userName);
        preparedStatement.executeUpdate();
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }
    }

    public void deleteUser(String userName) throws SQLException, ClassNotFoundException {
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE user_name=?");
        preparedStatement.setString(1, userName);
        preparedStatement.executeUpdate();
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }
    }


    public int findUserId(String userName) throws SQLException,ClassNotFoundException{
        int userId;
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT user_id FROM users WHERE user_name=?");
        preparedStatement.setString(1,userName);
        userId = preparedStatement.executeUpdate();

        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }
        return userId;

    }

}
