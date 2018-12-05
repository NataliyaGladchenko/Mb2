package interceptor;

import model.BaseModel;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import service.InitializationInterceptor;
import service.ModelService;

import java.io.Serializable;
import java.util.Set;

public class MainInterceptor implements InitializationInterceptor {
       @Override
    public void onInitialize(BaseModel entity) {
        ModelService.getInstance().create(entity.getClass());

    }
}
