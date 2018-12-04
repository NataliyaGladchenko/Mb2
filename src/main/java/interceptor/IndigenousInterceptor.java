package interceptor;

import model.IndigenousProfile;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import service.Interceptor;

import java.io.Serializable;
import java.lang.annotation.Annotation;

@Interceptor(cl=IndigenousProfile.class)
public class IndigenousInterceptor extends EmptyInterceptor implements Interceptor {
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof IndigenousProfile && (Integer.valueOf(((IndigenousProfile) entity).getNumberOfTripsAbroad())== null)){
            ((IndigenousProfile) entity).setNumberOfTripsAbroad(0);
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
