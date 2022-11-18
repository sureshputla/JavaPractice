package in.sp_java_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListRelated {
    public static void plusMinus(List<Integer> arr) {
        int negCount = 0;
        int posCount = 0;
        int zeros = 0;
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i) < 0)
                negCount++;
            else if(arr.get(i) > 0)
                posCount++;
            else
                zeros++;
        }
        float temp = (float) posCount/arr.size();
        System.out.println(temp);
        temp = (float) negCount/arr.size();
        System.out.println(temp);
        temp = (float) zeros/arr.size();
        System.out.println(temp);
    }

    public static void miniMaxSum(List<Integer> arr) {
        Long sum = 0L;
        Collections.sort(arr);
        for(int i=0; i < 4; i++){
            sum += arr.get(i);
        }
        System.out.print(sum);
        sum = 0L;
        for(int i=arr.size()-1; i >= arr.size()-4; i--){
            sum += arr.get(i);
        }
        System.out.print(" " + sum);
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> result = new ArrayList<>();
        for (String ele: queries) {
            result.add(Collections.frequency(stringList,ele));
        }
        return result;
    }

    public static boolean hasCycle(SinglyLinkedListNode head) {
        List<Integer> valueList = new ArrayList<>();
        while (null != head.getNext()){
            if (valueList.contains(head.getValue()))
                return true;
            else {
                valueList.add(head.getValue());
                head = head.getNext();
            }
        }
        return false;
    }

}
