package repository;

import interceptor.IndigenousInterceptor;
import model.ForeignersProfile;
import model.IndigenousProfile;
import model.Profile;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.xml.crypto.Data;
import java.util.List;

public class ProfileRepository {

    public List<Profile> getListProfile() {
        Session session = DataSource.getSessionFactory().openSession();
        List<Profile> profiles = session.createQuery("from Profile").list();
        session.close();
        return profiles;
    }

    public List<Profile> getListIndigenous(){
        Session session = DataSource.getSessionFactory().openSession();
        List<Profile> profiles = session.createQuery("from IndigenousProfile").list();
        session.close();
        return profiles;
    }

    public List<Profile> getListForeigners(){
        Session session = DataSource.getSessionFactory().openSession();
        List<Profile> profiles = session.createQuery("from ForeignersProfile").list();
        session.close();
        return profiles;
    }

    public void addFofeigners(int yearsInCountry, String nativeCountry, int userId, String profile) {
        Session session = DataSource.getSessionFactory().openSession();
        ForeignersProfile foreignersProfile = new ForeignersProfile();
        foreignersProfile.setNativeCountry(nativeCountry);
        foreignersProfile.setYearsInCountry(yearsInCountry);
        foreignersProfile.setUserId(userId);
        foreignersProfile.setProfile(profile);
        session.save(foreignersProfile);
        session.close();
    }


    public void addIndigenous(int numberOfTripsAbroad, int userId, String profile) {
        IndigenousInterceptor interceptor = new IndigenousInterceptor();
        Session session = DataSource.getSessionFactory().withOptions().interceptor(interceptor).openSession();
        IndigenousProfile indigenousProfile = new IndigenousProfile();
        indigenousProfile.setNumberOfTripsAbroad(numberOfTripsAbroad);
        indigenousProfile.setUserId(userId);
        indigenousProfile.setProfile(profile);
        session.save(indigenousProfile);
        session.close();
    }

    public void addProfile(int userId, String profile) {
        Session session = DataSource.getSessionFactory().openSession();
        Profile profile1 = new Profile();
        profile1.setUserId(userId);
        profile1.setProfile(profile);
        session.save(profile1);
        session.close();
    }

    public void addIndigenous(int userid, String profile) {
        IndigenousInterceptor interceptor = new IndigenousInterceptor();
        Session session = DataSource.getSessionFactory().withOptions().interceptor(interceptor).openSession();
        IndigenousProfile indigenousProfile = new IndigenousProfile();
        indigenousProfile.setUserId(userid);
        indigenousProfile.setProfile(profile);
        session.save(indigenousProfile);
        session.close();
    }
}
