package config;

import java.util.*;

public class SecurityConfig {
    private static final Map<String, List<String>> configMap = new HashMap<>();

    static {
        init();
    }

    private static void init(){
        List<String> urlPattensLogined = new ArrayList<>();
        urlPattensLogined.add("/user");
        urlPattensLogined.add("/question");
        urlPattensLogined.add("/profile");
        urlPattensLogined.add("/answers");

        configMap.put("Logined",urlPattensLogined);



    }

    public static Set<String> getAllAppRoles() {
        return configMap.keySet();
    }
    public static List<String> getUrlPatternsForRole(String role) {
        return configMap.get(role);
    }
}
