package in.sp_java_practice;

import java.util.*;

public class StringRelated {

    public static String[] inputArray = {"B$u$i$ld", "$t$$h$e", "N$e$x$t", "E$$ra", "$$o$f$", "S$$of$t$wa$r$e", "De$$ve$l$op$me$n$t"};

    public static String getProperString(String[] inputArray){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(inputArray).map(ele -> ele.replace("$","")).forEach(ele -> stringBuilder.append(ele.toUpperCase()).append(" "));
        return stringBuilder.toString();
    }
    public static String reverseOnlyChars(String str){
        StringBuilder result = new StringBuilder();
        char[] characters = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (Character character: characters){
            if (Character.isAlphabetic(character)){
                stack.push(character);
            } else {
                queue.add(character);
            }
        }
        return result.toString();
    }

    public static boolean queryString(String s, int n) {
        boolean sContainsAll = true;
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))){
                sContainsAll = false;
                break;
            }
        }
        return sContainsAll;
    }

    public static String timeConversion(String s) {
        String[] timeParts = s.split(":");
        StringBuilder stringBuilder = new StringBuilder();
        int time = Integer.parseInt(timeParts[0]);
        if (timeParts[2].charAt(2) == 'P'){
            if (time != 12)
                time += 12;
            stringBuilder.append(time).append(":");
        } else {
            if (time == 12){
                stringBuilder.append("00:");
            } else {
                if (time < 10)
                    stringBuilder.append("0");
                stringBuilder.append(time).append(":");
            }
        }
        stringBuilder.append(timeParts[1]).append(":");
        stringBuilder.append(timeParts[2], 0, 2);
        return stringBuilder.toString();
    }

    public static String alphabeticallySmallStringByRemovingOneLetter(String S) {
        List<Character> characters = new ArrayList<>();
        for (char ele:
             S.toCharArray()) {
            characters.add(ele);
        }
        for (int i = 0; i < characters.size()-1; i++) {
            if (characters.get(i) > characters.get(i+1)){
                characters.remove(i);
                break;
            }
            if (i == characters.size()-2){
                characters.remove(characters.size()-1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character ele:
             characters) {
            stringBuilder.append(ele);
        }
        return stringBuilder.toString();
    }

    public static int countBALLOONinGivenString(String S) {
        char[] chars = S.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ele:
             chars) {
            if (charCount.containsKey(ele)) {
                int tempCount = charCount.get(ele);
                charCount.put(ele, ++tempCount);
            } else {
                charCount.put(ele, 1);
            }
        }
        int count = Integer.MAX_VALUE;
        for (Character ele:
             "BALON".toCharArray()) {
            if (charCount.containsKey(ele)){
                if ((ele.equals('B') || ele.equals('A') || ele.equals('N'))) {
                    if (charCount.get(ele) < count) {
                        count = charCount.get(ele);
                    }
                } else {
                    if ((charCount.get(ele)/2) < count) {
                        count = (charCount.get(ele)/2);
                    }
                }
            }
        }
        return count;
    }
}
