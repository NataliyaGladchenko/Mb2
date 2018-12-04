package servlet;

import model.Answers;
import model.Users;
import repository.AnswersRepository;
import repository.UsersRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AnswersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        UsersRepository usersRepository = new UsersRepository();
        AnswersRepository answersRepository = new AnswersRepository();
        List<Users> usersList = null;
        List<Answers> answersList = null;
        usersList = usersRepository.getAllUsers();

        for (Users users : usersList) {
            int userId = users.getUserId();
            answersList = answersRepository.getAnswersByUserId(userId);
            users.setAnswersList(answersList);
        }

        PrintWriter printWriter = resp.getWriter();
        for (Users users : usersList) {
            printWriter.println(users);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        AnswersRepository answersRepository = new AnswersRepository();
        answersRepository.answerTheQuestion(req.getParameter("answer"), Integer.parseInt(req.getParameter("question_id")),req.getParameter("user_name"));
    }
}
