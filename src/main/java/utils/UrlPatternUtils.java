package utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

public class UrlPatternUtils {

    public static boolean hasUrlPattern(ServletContext context, String urlPattern){
        Map<String, ? extends ServletRegistration> map = context.getServletRegistrations();
        for (String servletName : map.keySet()) {
            ServletRegistration registration = map.get(servletName);
            Collection<String> mappings = registration.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    public static String getUrlPattern(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();

        String urlPattern = null;
        if (pathInfo != null) {
            urlPattern = servletPath + "/*";
            return urlPattern;
        }
        urlPattern = servletPath;

        boolean has = hasUrlPattern(servletContext, urlPattern);
        if (has) {
            return urlPattern;
        }
        int i = servletPath.lastIndexOf('.');
        if (i != -1) {
            String ext = servletPath.substring(i + 1);
            urlPattern = "*." + ext;
            has = hasUrlPattern(servletContext, urlPattern);

            if (has) {
                return urlPattern;
            }
        }
        return "/";
    }
}
