package repository;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public  class DataSource {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
