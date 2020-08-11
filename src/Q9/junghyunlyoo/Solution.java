package Q9.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-08-09
 * @DESCRIPTION
 */

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char currentChar : chars) {
            if (isOpenBracket(currentChar)) {
                stack.add(currentChar);
            } else if (stack.size() == 0) {
                return false;
            } else {
                Character prevChar = stack.pop();
                if (!isValidCharOrder(prevChar, currentChar)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private boolean isOpenBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isValidCharOrder(char prevChar, char currentChar) {
        if (prevChar == '(') {
            return currentChar == ')';
        } else if (prevChar == '{') {
            return currentChar == '}';
        } else if (prevChar == '[') {
            return currentChar == ']';
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputArrays = new String[]{"[", "()", "()[]{}", "(]", "([)]", "{[]}"};
        for (String inputArray : inputArrays) {
            System.out.println(inputArray + " :: " + solution.isValid(inputArray));
        }
    }
}
