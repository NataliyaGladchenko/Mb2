package repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private static DataSource INSTANSE;

    private String dbName;
    private String dbUser;
    private String dbPassword;

    private DataSource(){
        try {

            Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
            this.dbName = properties.getProperty("db.name");
            this.dbUser = properties.getProperty("db.user");
            this.dbPassword = properties.getProperty("db.password");

        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static DataSource getInstance() {
        if (INSTANSE == null) {
            INSTANSE = new DataSource();
        }
        return INSTANSE;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(dbName, dbUser, dbPassword);
    }
}
