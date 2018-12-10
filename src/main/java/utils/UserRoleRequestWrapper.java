package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;
import java.util.List;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {
    private String user;
    private List<String> role = null;
    private HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String user, List<String> role, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.role = role;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String userRole) {
        if (role == null) {
            return this.realRequest.isUserInRole(userRole);
        }
        return role.contains(userRole);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.user == null) {
            return realRequest.getUserPrincipal();
        }
        return new Principal() {
            @Override
            public String getName() {
                return user;
            }
        };
    }


}
