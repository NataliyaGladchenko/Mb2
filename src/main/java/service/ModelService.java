package service;

import model.BaseModel;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModelService {
    private Map<Class<? extends BaseModel>, Set<InitializationInterceptor>> initializationInterceptors;

    private static ModelService INSTANCE;

    private ModelService() {
        initializeInterceptorRegistry();
    }

    private static ModelService getInstance() {
        synchronized (INSTANCE) {
            if (INSTANCE == null) {
                INSTANCE = new ModelService();
            }
        }
        return INSTANCE;
    }

    public <T extends BaseModel> T create(Class<T> aClass) {
        try {
            T model = aClass.newInstance();
            Set<InitializationInterceptor> interceptors = initializationInterceptors.get(aClass);
            if (interceptors != null){
                for (InitializationInterceptor interceptor : interceptors) {
                    interceptor.onInitialize(model);
                }
            }
            return model;
        } catch (Exception e) {
            throw new RuntimeException("Impossible to instantiate model of class " + aClass.getName());
        }
    }

    private void initializeInterceptorRegistry() {
        Reflections reflections = new Reflections("interceptor");
        Set<Class<?>> interceptorsClasses = reflections.getTypesAnnotatedWith(Interceptor.class);
        Set<Object> instances = new HashSet<>();
        for (Class<?> interceptorsClass : interceptorsClasses) {
            try {
                instances.add(interceptorsClass.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Can not instantiate class " + interceptorsClass.getName());
            }
        }
        for (Object instance : instances) {
            if (instance instanceof InitializationInterceptor) {
                Class key = instance.getClass().getAnnotation(Interceptor.class).cl();
                if (initializationInterceptors.get(key) == null) {
                    Set<InitializationInterceptor> newValue = new HashSet<>();
                    newValue.add((InitializationInterceptor) instance);
                    initializationInterceptors.put(key, newValue);
                } else {
                    initializationInterceptors.get(key).add((InitializationInterceptor) instance);
                }
            }
        }
    }

}
