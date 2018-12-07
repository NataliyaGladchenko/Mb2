import model.Users;
import repository.UsersRepository;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepository();
       System.out.println(usersRepository.findUser("Andrew", 1111));




    }
}
