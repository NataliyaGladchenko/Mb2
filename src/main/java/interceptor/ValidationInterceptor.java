package interceptor;

import model.Users;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import service.Interceptor;

import java.io.Serializable;

@Interceptor(cl=Users.class)
public class ValidationInterceptor extends EmptyInterceptor {
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
        if (entity instanceof Users &&(((Users) entity).getAge()<6)){
            System.out.println("Invalid value");
            throw new CallbackException("");
        }else if (entity instanceof Users &&(((Users) entity).getAge()>106)){
            System.out.println("Invalid value");
            throw new CallbackException("");
        }
        return false;
    }
}
