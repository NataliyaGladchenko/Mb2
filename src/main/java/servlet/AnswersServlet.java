package servlet;

import model.Answers;
import model.Users;
import repository.AnswersRepository;
import repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class AnswersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersRepository usersRepository = new UsersRepository();
        AnswersRepository answersRepository = new AnswersRepository();
        List<Users> usersList = null;
        List<Answers> answersList = null;
        try {
            usersList = usersRepository.getAllUsers();

            for (Users users : usersList) {
                int userId = users.getUserId();
                answersList = answersRepository.getAnswersByUserId(userId);
                users.setAnswersList(answersList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        req.setAttribute("users", usersList);
//        req.getRequestDispatcher("index.jsp").forward(req, resp);
        PrintWriter printWriter = resp.getWriter();
        for (Users users : usersList) {
            printWriter.println(users);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersRepository usersRepository = new UsersRepository();
        AnswersRepository answersRepository = new AnswersRepository();
        try {
            int userId = usersRepository.findUserId(req.getParameter("user_name"));
            int questionId = Integer.parseInt(req.getParameter("question_id"));
            String answer = req.getParameter("answer");
            answersRepository.answerTheQuestion(answer,questionId,userId);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
