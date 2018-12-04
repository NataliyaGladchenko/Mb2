import reflection.Refl;

import java.util.Map;

public class Runner {
    public static void main(String[] args) throws ClassNotFoundException {
//        Users user = new Users(5,"in"," ", 19);
//        String name = null; //no getter
//        System.out.println(name);//output null
//        try {
//            Field field = user.getClass().getDeclaredField("userName");
//            field.setAccessible(true);
//            name = (String) field.get(user);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        System.out.println(name);//output in

        Refl refl = new Refl();
        try {
            Map map = refl.getMap();
            for (Object m : map.values()) {
                System.out.println(m);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
