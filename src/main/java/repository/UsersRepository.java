package repository;

import model.Users;
import org.hibernate.Session;
import service.ModelService;

import javax.persistence.Query;
import java.util.List;

public class UsersRepository {

    public List<Users> getAllUsers() {
        Session session = DataSource.getSessionFactory().openSession();
        List<Users> usersList = session.createQuery("from Users").list();
        session.close();
        return usersList;
    }

    public void addUser(String userName, String pasportData, int age) {
        Session session = DataSource.getSessionFactory().openSession();
        Users user = new Users();
        user.setUserName(userName);
        user.setPasportData(pasportData);
        user.setAge(age);
        session.save(user);
        session.close();

    }

    public void addUserWithDV(String userName, int age) {
        Session session = DataSource.getSessionFactory().openSession();
        Users user = ModelService.getInstance().create(Users.class);
        user.setUserName(userName);
        user.setAge(age);
        session.save(user);
        session.close();
    }

    public void deleteUser(String userName) {
        Session session = DataSource.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Users where userName=?1");
        query.setParameter(1, userName);
        query.executeUpdate();

        session.close();
    }


}
