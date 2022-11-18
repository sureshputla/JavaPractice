package in.sp_java_practice;

import java.util.ArrayList;
import java.util.List;

public class RecursionRelated {
    public static List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        generateParenthesis(resultList, 0, 0, "", n);
        return resultList;
    }

    private static void generateParenthesis(List<String> resultList, int leftCount, int rightCount, String stringWithParenthesis, int n) {
        if (stringWithParenthesis.length() == n*2){
            resultList.add(stringWithParenthesis);
            return;
        }
        if (leftCount < n){
            generateParenthesis(resultList,leftCount+1,rightCount,stringWithParenthesis+"(",n);
        }
        if (rightCount < leftCount){
            generateParenthesis(resultList,leftCount,rightCount+1,stringWithParenthesis+")",n);
        }
    }


    public static List<List<Character>> generateAnagrams(String string) {
        List<List<Character>> result = new ArrayList<>();
        generateAnagrams(result, new ArrayList<>(), string.toCharArray());
        return result;
    }

    private static void generateAnagrams(List<List<Character>> result, List<Character> currentString, char[] charArray) {
        if (currentString.size() == charArray.length) {
            result.add(new ArrayList<>(currentString));
        } else {
            for (char c : charArray) {
                if (currentString.contains(c)) {
                    continue;
                }
                currentString.add(c);
                generateAnagrams(result, currentString, charArray);
                currentString.remove(currentString.size() - 1);
            }
        }
    }

    private static void generateAnagramsWithDupes(List<List<Character>> result, List<Character> currentString, List<Integer> position, char[] charArray) {
        if (currentString.size() == charArray.length) {
            result.add(new ArrayList<>(currentString));
        } else {
            for (int i = 0; i < charArray.length; i++) {
                if (position.contains(i)){
                    continue;
                }
                currentString.add(charArray[i]);
                position.add(i);
                generateAnagrams(result, currentString, charArray);
                currentString.remove(currentString.size() - 1);
            }
        }
    }

//    public List<String> letterCombinations(String digits) {
//        List<String> resultList = new ArrayList<>();
//        String[] groupsOfLetters = new String[digits.length()];
//        int count = 0;
//        for (char n:
//             digits.toCharArray()) {
//            switch (n){
//                case '2':
//                    groupsOfLetters[count++] = "abc";
//                    break;
//                case '3':
//                    groupsOfLetters[count++] = "def";
//                    break;
//                case '4':
//                    groupsOfLetters[count++] = "ghi";
//                    break;
//                case '5':
//                    groupsOfLetters[count++] = "jkl";
//                    break;
//                case '6':
//                    groupsOfLetters[count++] = "mno";
//                    break;
//                case '7':
//                    groupsOfLetters[count++] = "pqrs";
//                    break;
//                case '8':
//                    groupsOfLetters[count++] = "tuv";
//                    break;
//                case '9':
//                    groupsOfLetters[count++] = "wxyz";
//            }
//        }
//        generateAnagrams(resultList,groupsOfLetters, "", digits.length());
//        return resultList;
//    }

//    private void generateAnagrams(List<String> resultList, String[] groupsOfLetters, String resultString, int length) {
//        if (resultString.length() == length){
//            resultList.add(resultString);
//            return;
//        }
//        for (int i = 0; i < ; i++) {
//
//        }
//    }
}
