package utils;

import config.SecurityConfig;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class SecurityUtils {

    public static boolean isSecurityPage(HttpServletRequest req) {
        String urlPattern = UrlPatternUtils.getUrlPattern(req);

        Set<String> roles = SecurityConfig.getAllAppRoles();
        for (String role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPattern != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }


    public static boolean hasPermission(HttpServletRequest req){
        String urlPattern = UrlPatternUtils.getUrlPattern(req);
        Set<String> allRoles = SecurityConfig.getAllAppRoles();
        for (String role : allRoles) {
            if (!role.equals("Logined")) {
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
