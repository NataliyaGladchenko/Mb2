package utils;

import config.SecurityConfig;
import model.UsersRole;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class SecurityUtils {

    public static boolean isSecurityPage(HttpServletRequest req) {
        String urlPattern = UrlPatternUtils.getUrlPattern(req);

        Set<UsersRole> roles = SecurityConfig.getAllAppRoles();
        for (UsersRole role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPattern != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }


    public static boolean hasPermission(HttpServletRequest req){
        String urlPattern = UrlPatternUtils.getUrlPattern(req);
        Set<UsersRole> allRoles = SecurityConfig.getAllAppRoles();
        for (UsersRole role : allRoles) {
            if (!req.isUserInRole(role.toString())) {
                continue;
            }
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }
}
