package repository;

import model.Answers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswersRepository {

    public List<Answers> getAnswersByUserId(int userId) throws SQLException, ClassNotFoundException {
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT answer_id,answer,user_id,question_id FROM answers WHERE user_id=? ");
        preparedStatement.setInt(1,userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Answers> answersList = new ArrayList<>();
        while (resultSet.next()) {
            Answers answer = new Answers(resultSet.getInt("answer_id"), resultSet.getString("answer"), resultSet.getInt("user_id"), resultSet.getInt("question_id"));
            answersList.add(answer);
        }
        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }
        return answersList;
    }

    public void answerTheQuestion(String answer, int questionId, int userId) throws SQLException,ClassNotFoundException{
        Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO answers(answer, user_id, question_id) VALUES (?,?,?)");
        preparedStatement.setString(1,answer);
        preparedStatement.setInt(2,userId);
        preparedStatement.setInt(3,questionId);
        preparedStatement.executeUpdate();

        if (preparedStatement!=null){
            preparedStatement.close();
        }
        if (connection!=null){
            connection.close();
        }


    }


}
