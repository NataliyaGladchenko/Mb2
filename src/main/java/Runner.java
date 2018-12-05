import model.Users;
import service.ModelService;

public class Runner {
    public static void main(String[] args)  {
        Users user = ModelService.getInstance().create(Users.class);
        user.setUserName("t");
        user.setAge(15);
        user.setPasportData(null);
        System.out.println(user);


    }
}
