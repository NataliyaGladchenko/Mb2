package utils;

import model.UsersRole;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;
import java.util.List;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {
    private String user;
    private List<UsersRole> roles = null;
    private HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String user, List<UsersRole> roles, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.roles = roles;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (roles == null) {
            return this.realRequest.isUserInRole(role);
        }
        return roles.contains(role);
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
