package Q9.jubin;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        HashMap<Character, Character> valid_def = new HashMap<>();
        Stack<Character> check_stack = new Stack<>();

        valid_def.put('(', ')');
        valid_def.put('{', '}');
        valid_def.put('[', ']');

        for(char char_item : s.toCharArray()){
            if (valid_def.get(char_item) != null){
                check_stack.push(char_item);
            }else{
                if(check_stack.empty()){
                    return false;
                }else{
                    if(valid_def.get(check_stack.pop()) != char_item){
                        return false;
                    }
                }
            }
        }

        return check_stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid(")("));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("(])"));

    }
}
