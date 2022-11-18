package in.sp_java_practice;

import java.util.Arrays;
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
}
