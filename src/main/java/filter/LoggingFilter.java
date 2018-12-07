package filter;

import config.SecurityConfig;
import model.Users;
import model.UsersRole;
import repository.UsersRepository;
import utils.AppUtils;
import utils.SecurityUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

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

        }
        if (SecurityUtils.isSecurityPage(req)) {
            if (user == null) {
                return;
            }
            boolean hasPermission = SecurityUtils.hasPermission(req);
            if (!hasPermission) {

                return;
            }

        }

        chain.doFilter(request, response);


    }


}
