package Q9.hyowon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    /**
     * 시간복잡도 O(n)
     * char 배열을 돌면서 괄호가 열리면 스택에 push, 괄호가 닫히면 스택의 값과 비교해 pop
     * {}, (), [] 짝을 맞출 수 있도록 닫는 괄호가 키인 HashMap 생성
     * Runtime: 2 ms, faster than 52.21% of Java online submissions for Valid Parentheses.
     * Memory Usage: 37.4 MB, less than 54.23% of Java online submissions for Valid Parentheses.
     * */
    public static boolean isValid(String s) {
        Stack<Character> parenthesis = new Stack<>();
        char[] ch = s.toCharArray();

        Map<Character, Character> parenthesisPair = new HashMap<>();
        parenthesisPair.put(']','[');
        parenthesisPair.put('}','{');
        parenthesisPair.put(')','(');

        for (char c : ch) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    parenthesis.push(c);
                    break;
                case ']':
                case '}':
                case ')':
                    if (parenthesis.size() != 0 && parenthesis.peek() == parenthesisPair.get(c)) {
                        parenthesis.pop();
                    } else {
                        return false;
                    }
            }
        }

        return (parenthesis.size() == 0);
    }
}