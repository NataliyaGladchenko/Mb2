package service;

import model.BaseModel;
import org.hibernate.type.Type;

import java.io.Serializable;

public interface InitializationInterceptor {
    void onInitialize(BaseModel baseModel);

}
