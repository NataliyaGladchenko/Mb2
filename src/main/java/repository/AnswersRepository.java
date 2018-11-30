package repository;

import model.Answers;
import org.hibernate.Session;


import javax.persistence.Query;

import java.util.List;

public class AnswersRepository {


    public List<Answers> getAnswersByUserId(int userId) {
        Session session = DataSource.getSessionFactory().openSession();
        Query query = session.createQuery("from Answers where userId=?1");
        query.setParameter(1,userId);
        List<Answers> answersList = ((org.hibernate.query.Query) query).list();
        session.close();
        return answersList;
    }

    public void answerTheQuestion(String answer, int questionId, String userName) {
        Session session = DataSource.getSessionFactory().openSession();
        Query query = session.createQuery("select userId from Users where userName=?1");
        query.setParameter(1, userName);
        int userId = (int) ((org.hibernate.query.Query) query).uniqueResult();
        Answers answers = new Answers();
        answers.setAnswer(answer);
        answers.setQuestionId(questionId);
        answers.setUserId(userId);
        session.save(answers);
        session.close();
    }


    public void answer(String answer, String userName){
        Session session = DataSource.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select userId from Users where userName=?1");
        query.setParameter(1, userName);
        int userId = (int) ((org.hibernate.query.Query) query).uniqueResult();
        Query query2 = session.createQuery("update Answers set answer=?1 where userId=?2 and answer is null");
        query2.setParameter(1,answer);
        query2.setParameter(2,userId);
        query2.executeUpdate();
        session.close();


    }
}
