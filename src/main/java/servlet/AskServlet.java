package servlet;

import repository.QuestionRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionRepository questionRepository = new QuestionRepository();
        questionRepository.ask(req.getParameter("user_name"),Integer.parseInt(req.getParameter("question_id")));
    }
}
