package servlet;

import model.Users;
import repository.UsersRepository;
import utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user_name");
        int password = Integer.parseInt(req.getParameter("password"));
        Users user = new UsersRepository().findUser(userName, password);

        PrintWriter printWriter = resp.getWriter();
        if (user == null) {
            printWriter.println("Invalid userName or Password");

        } else {
            printWriter.println("Successful login " + user);
        }

        AppUtils.storeLoginedUser(req.getSession(), user);

        int redirectId = -1;
        try {
            redirectId = Integer.parseInt(req.getParameter("redirectId"));
        } catch (Exception e) {
        }
        String requestUri = AppUtils.getRedirectAfterLoginUrl(req.getSession(), redirectId);
        if (requestUri != null) {
            resp.sendRedirect(requestUri);
        } else {

            resp.sendRedirect(req.getContextPath() + "/user");
        }
    }
}
