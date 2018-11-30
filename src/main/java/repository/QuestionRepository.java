package repository;

import model.Answers;
import model.Questions;

import java.util.List;

import model.Users;
import org.hibernate.Session;


import javax.persistence.Query;

public class QuestionRepository {


    public List<Questions> getAllQuestions() {
        Session session = DataSource.getSessionFactory().openSession();
        List<Questions> questionsList = session.createQuery("from Questions").list();
        session.close();
        return questionsList;
    }

    public void addQuestion(String question) {
        Session session = DataSource.getSessionFactory().openSession();
        Questions questions = new Questions();
        questions.setQuestion(question);
        session.save(questions);
        session.close();

    }

    public void deleteQuestion(int questionId) {
        Session session = DataSource.getSessionFactory().openSession();
        Query query = session.createQuery("delete from Questions where questionId=?1");
        query.setParameter(1,questionId);


    }

    public void ask(String userName, int questionId){
        Session session = DataSource.getSessionFactory().openSession();
        Answers answers = new Answers();
        Query query = session.createQuery("from Users where userName=?1");
        query.setParameter(1,userName);
        Users users = (Users) ((org.hibernate.query.Query) query).uniqueResult();
        int userId = users.getUserId();
        answers.setUserId(userId);
        answers.setQuestionId(questionId);
        session.save(answers);
        session.close();
    }
}
