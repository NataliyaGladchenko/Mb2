package interceptor;

import model.IndigenousProfile;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

public class IndigenousInterceptor extends EmptyInterceptor {
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof IndigenousProfile && (Integer.valueOf(((IndigenousProfile) entity).getNumberOfTripsAbroad())== null)){
            ((IndigenousProfile) entity).setNumberOfTripsAbroad(0);
            return true;
        }
        return false;
    }
}
