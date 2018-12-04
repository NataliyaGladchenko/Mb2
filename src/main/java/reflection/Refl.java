package reflection;

import service.Interceptor;
import org.hibernate.EmptyInterceptor;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Refl {
   private Map<Class, Set<EmptyInterceptor>> map = new HashMap<>();

    public Map getMap() throws InstantiationException,IllegalAccessException{
        Reflections reflections = new Reflections("interceptor");
        Set<Class<?>> interceptors = reflections.getTypesAnnotatedWith(Interceptor.class);
        Set<EmptyInterceptor> emptyInterceptors;
        Class key;
        for (Class<?> aClass : interceptors) {
            key = aClass.getAnnotation(Interceptor.class).cl();
            EmptyInterceptor interceptor = (EmptyInterceptor) aClass.newInstance();
            if (map.get(key) == null) {
                emptyInterceptors = new HashSet<>();
            } else {
                emptyInterceptors = map.get(key);
            }
            emptyInterceptors.add(interceptor);
            map.put(key, emptyInterceptors);
        }
        return map;
    }


}
