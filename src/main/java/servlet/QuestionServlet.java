package servlet;

import model.Questions;
import repository.QuestionRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionRepository questionRepository = new QuestionRepository();
        List<Questions> questionsList = null;
        try {
            questionsList = questionRepository.getAllQuestions();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        req.setAttribute("questionsList", questionsList);
//
//        req.getRequestDispatcher("question.jsp").forward(req, resp);
        PrintWriter print = resp.getWriter();
        for (Questions questions : questionsList) {
            print.println(questions);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionRepository questionRepository = new QuestionRepository();
        try {
            questionRepository.deleteQuestion(Integer.parseInt(req.getParameter("question_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        req.getRequestDispatcher("question.jsp").forward(req, resp);
    }
}
