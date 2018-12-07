package model;


import converter.CaseConverter;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "user_id")})
//@FilterDef(name = "usersFilter", parameters = @ParamDef(name = "age", type = "int"))
//@Filter(name = "usersFilter" , condition = "age>:age")
public class Users extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private int userId;

    @Column(name = "user_name")
    @Convert(converter = CaseConverter.class)
    private String userName;

    @Column(name = "pasport_data")
    @ColumnTransformer(read = "pgp_sym_decrypt(pasport_data::bytea,'secretKey')",
            write = "pgp_sym_encrypt(?,'secretKey')")
    private String pasportData;

    @Column(name = "age")
    private int age;

    @Column(name = "password")
    private int password;

    @OneToMany(targetEntity = Answers.class)
    private List<Answers> answersList;


    public Users(int userId, String userName, String pasportData, int age,int password, List<Answers> answersList) {
        this.userId = userId;
        this.userName = userName;
        this.pasportData = pasportData;
        this.age = age;
        this.password = password;
        this.answersList = answersList;

    }

    public Users() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Answers> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answers> answersList) {
        this.answersList = answersList;
    }

    public String getPasportData() {
        return pasportData;
    }

    public void setPasportData(String pasportData) {
        this.pasportData = pasportData;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return userName + age;
    }


}
