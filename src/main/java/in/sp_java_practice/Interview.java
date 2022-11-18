package in.sp_java_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Interview {
    public static int[] returnUniqueEle(int[] arr){
        Map<Integer, Integer> countOfIntegers = new HashMap<>();
        for (int ele: arr) {
            if (countOfIntegers.containsKey(ele)){
                int temp = countOfIntegers.get(ele);
                countOfIntegers.put(ele, ++temp);
            } else {
                countOfIntegers.put(ele, 1);
            }
        }
        for (int i=0; i<arr.length; i++) {
            if (countOfIntegers.get(arr[i]) > 1){
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static List<Integer> getAll(int num, List<Integer> numbers){
        List<Integer> result = new ArrayList<>();
        result = numbers.stream().filter(ele -> ele.equals(num)).collect(Collectors.toList());
        numbers.removeAll(result);
        return result;
    }
}
