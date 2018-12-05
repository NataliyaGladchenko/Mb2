package repository;

import interceptor.MainInterceptor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public  class DataSource {

    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();

            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){

        return sessionFactory;
    }

}
