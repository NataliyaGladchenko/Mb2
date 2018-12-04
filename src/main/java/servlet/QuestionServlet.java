package servlet;

import model.Questions;
import repository.QuestionRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        QuestionRepository questionRepository = new QuestionRepository();
        List<Questions> questionsList = null;
        questionsList = questionRepository.getAllQuestions();

        PrintWriter print = resp.getWriter();
        for (Questions questions : questionsList) {
            print.println(questions);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        QuestionRepository questionRepository = new QuestionRepository();
        questionRepository.addQuestion(req.getParameter("question"));
    }
}
