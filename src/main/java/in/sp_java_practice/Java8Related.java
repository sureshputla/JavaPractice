package in.sp_java_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8Related {
    public static void findEven(int[] arr){
        Arrays.stream(arr)
                .filter(i -> i%2 ==0)
//                .boxed()
//                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    public static void startsWithParticularInt(List<Integer> list){
        list.stream()
                .map(s -> s+"")
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);
    }

    public static void sorting(){
        try {
            List<UserDef> users = new ArrayList<>();
            users.add(new UserDef("Surya", 2));
            users.add(new UserDef("Sneha", 1));
            users.add(new UserDef("Suresh", 3));
            users.add(new UserDef("Chitti", 4));
            users.sort(Comparator.comparing(UserDef::getName).reversed());
            List<UserDef> sortedUsers = users.stream().sorted(Comparator.comparing(UserDef::getId).reversed()).toList();
            for (UserDef user: users) {
                System.out.println(user);
            }
            for (UserDef user: sortedUsers) {
                System.out.println(user);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
