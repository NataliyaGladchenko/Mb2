package servlet;

import model.Profile;
import repository.ProfileRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfileRepository profileRepository = new ProfileRepository();
        List<Profile> profiles = null;
        profiles = profileRepository.getListIndigenous();
        PrintWriter printWriter = resp.getWriter();
        for (Profile profile : profiles) {
            printWriter.println(profile);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfileRepository profileRepository = new ProfileRepository();
        if (req.getParameter("number").isEmpty()) {
            profileRepository.addIndigenous(Integer.parseInt(req.getParameter("user_id")), req.getParameter("profile"));
        } else {
            profileRepository.addIndigenous(Integer.parseInt(req.getParameter("number")), Integer.parseInt(req.getParameter("user_id")), req.getParameter("profile"));
        }
    }
}
