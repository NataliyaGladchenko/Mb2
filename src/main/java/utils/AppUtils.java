package utils;

import model.Users;

import javax.servlet.http.HttpSession;

public class AppUtils {

    public static void storeLoginedUser(HttpSession session, Users loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }
    public static Users getLoginedUser(HttpSession session){
        Users loginedUser = (Users) session.getAttribute("loginedUser");
        return loginedUser;
    }
}
