package filter;

import model.Users;
import utils.AppUtils;
import utils.SecurityUtils;
import utils.UserRoleRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    public LoggingFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String servletPath = req.getServletPath();

        Users user = AppUtils.getLoginedUser(req.getSession());
        if (servletPath.equals("/login")) {
            chain.doFilter(req, resp);
            return;
        }
        HttpServletRequest wrapRequest = req;
        if (user != null) {
            String userName = user.getUserName();
            List<String> role = new ArrayList<>();
            String string = "Logined";
            role.add(string);
            wrapRequest = new UserRoleRequestWrapper(userName, role, req);
        } else {
            List<String> role = new ArrayList<>();
            String string = "Unlogined";
            role.add(string);
            wrapRequest = new UserRoleRequestWrapper(null, role, req);
        }
        if (SecurityUtils.isSecurityPage(req)) {
            if (user == null) {
                String requestUri = req.getRequestURI();
                int redirectId = AppUtils.storeRedirectAfterLoginUrl(req.getSession(), requestUri);
                resp.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }
            boolean hasPermission = SecurityUtils.hasPermission(req);
            if (!hasPermission) {
                PrintWriter printWriter = resp.getWriter();
                printWriter.println("Permission == " + hasPermission);
                return;
            }

        }

        chain.doFilter(request, response);


    }


}
