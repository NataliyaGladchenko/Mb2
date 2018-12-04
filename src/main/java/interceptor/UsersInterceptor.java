package interceptor;

import model.Users;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import service.Interceptor;
import service.ModelService;

import java.io.Serializable;
import java.lang.annotation.Annotation;

@Interceptor(cl=Users.class)
public class UsersInterceptor extends EmptyInterceptor implements Interceptor {
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof Users && (((Users) entity).getPasportData()==null)){
            ((Users) entity).setPasportData("No data");
            return true;
        }
        return false;
    }



    @Override
    public Class<? extends Annotation> annotationType() {

        return null;
    }

    @Override
    public Class<?> cl() {
        return null;
    }
}
