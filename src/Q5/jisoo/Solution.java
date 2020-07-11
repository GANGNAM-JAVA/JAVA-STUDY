package Q5.jisoo;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("()(((()())(())()))(())")); // 17
        System.out.println(solution("()()()")); // 0
        System.out.println(solution("(())")); // 2
        System.out.println(solution("((()))")); // 4
    }
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<arrangement.length() ; i++) {
            char ch = arrangement.charAt(i);

            // i가 마지막 끝 요소가 아니고, 바로 다음 요소가 ')'이면 레이저 처리
            if(i < arrangement.length() - 1) {
                char ch2 = arrangement.charAt(i+1);
                if(ch == '(' && ch2 == ')') {
                    answer += s.size();
                    i++;
                    continue;
                }
            }

            if(ch == '(') {
                s.push(ch);
            }
            else if(ch == ')') {
                s.pop();
                answer++;
            }
        }
        return answer;
    }
}
