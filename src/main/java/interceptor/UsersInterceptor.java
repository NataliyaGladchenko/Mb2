package interceptor;

import model.BaseModel;
import model.Users;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import service.InitializationInterceptor;
import service.Interceptor;

import java.io.Serializable;

@Interceptor(cl = Users.class)
public class UsersInterceptor  implements InitializationInterceptor {

    @Override
    public void onInitialize(BaseModel entity) {
        ((Users) entity).setPasportData("No data");
    }
}
