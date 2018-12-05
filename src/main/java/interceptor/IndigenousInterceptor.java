package interceptor;

import model.BaseModel;
import model.IndigenousProfile;
import service.InitializationInterceptor;
import service.Interceptor;

@Interceptor(cl = IndigenousProfile.class)
public class IndigenousInterceptor implements InitializationInterceptor {

    @Override
    public void onInitialize(BaseModel entity) {
        ((IndigenousProfile) entity).setNumberOfTripsAbroad(0);
    }
}
