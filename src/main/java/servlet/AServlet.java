package servlet;

import repository.AnswersRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        AnswersRepository answersRepository = new AnswersRepository();
        answersRepository.answer(req.getParameter("answer"),req.getParameter("user_name"));
    }
}
