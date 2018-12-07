package config;

import model.UsersRole;

import java.util.*;

public class SecurityConfig {
    private static final Map<UsersRole, List<String>> configMap = new HashMap<>();

    static {
        init();
    }

    private static void init(){
        List<String> urlPattensLogined = new ArrayList<>();
        urlPattensLogined.add("/user");
        urlPattensLogined.add("/question");
        urlPattensLogined.add("/profile");
        urlPattensLogined.add("/answers");

        configMap.put(UsersRole.LOGINED,urlPattensLogined);

        List<String> urlPatternsUnlogined = new ArrayList<>();

        urlPatternsUnlogined.add("/answers");

        configMap.put(UsersRole.UNLOGINED,urlPatternsUnlogined);

    }

    public static Set<UsersRole> getAllAppRoles() {
        return configMap.keySet();
    }
    public static List<String> getUrlPatternsForRole(UsersRole role) {
        return configMap.get(role);
    }
}
