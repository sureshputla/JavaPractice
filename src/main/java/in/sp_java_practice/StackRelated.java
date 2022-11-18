package in.sp_java_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackRelated {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character:
             s.toCharArray()) {
            if (character.equals('{') || character.equals('(') || character.equals('[')){
                stack.push(character);
            } else {
                if (stack.isEmpty())
                    return false;
                if (isBalanced(stack, character)) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isBalanced(Stack<Character> stack, Character character) {
        switch (character){
            case '}':
                if (!stack.pop().equals('{')){
                    return true;
                }
                break;
            case ')':
                if (!stack.pop().equals('(')){
                    return true;
                }
                break;
            case ']':
                if (!stack.pop().equals('[')){
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    public static int bracket_match(String bracket_string) {
        int closingBraces = 0;
        int openingBraces = 0;
        for (Character character:
             bracket_string.toCharArray()) {
            if (character.equals('('))
                openingBraces++;
            else
                closingBraces++;
        }
        return closingBraces<openingBraces? closingBraces - openingBraces : openingBraces - closingBraces;
    }
}
