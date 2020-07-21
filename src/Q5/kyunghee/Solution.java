import java.util.*;

class Solution {
    public int solution(String arrangement) {
        // 괄호 문자열 arrangement
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < arrangement.length(); i++) {
            if(arrangement.charAt(i) == '(') {
                // '(' 문자인 경우 스택에 집어넣는다
                stack.push('(');
            } else {
                // 스택의 맨 위값을 pop 한다
                stack.pop();

                if(arrangement.charAt(i-1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}