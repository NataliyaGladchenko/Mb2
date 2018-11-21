package repository;

import model.Questions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.Driver;

public class QuestionRepository {

    public List<Questions> getAllQuestions() throws SQLException, ClassNotFoundException {

        Connection connection = DataSource.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM questions");
        List<Questions> questionsList = new ArrayList<Questions>();
        while (resultSet.next()) {
            Questions question = new Questions(resultSet.getInt("question_id"), resultSet.getString("question"));
            questionsList.add(question);
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return questionsList;
    }

    public void addQuestion(String question) throws SQLException, ClassNotFoundException {
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO questions(question) VALUES (?)");
        preparedStatement.setString(1, question);
        preparedStatement.executeUpdate();
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }

    }

    public void deleteQuestion(int questionId) throws SQLException, ClassNotFoundException {
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM questions WHERE question_id=?");
        preparedStatement.setInt(1, questionId);
        preparedStatement.executeUpdate();
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }
    }
}
