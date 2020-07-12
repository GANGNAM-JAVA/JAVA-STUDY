package Q5.jonghun;

import java.util.Stack;

class Solution {
    public static int solution(String arrangement) {

        int answer = 0;

        arrangement = arrangement.replace("()","0");

        Stack stack = new Stack<>();

        for(int i = 0 ; i< arrangement.length(); i++){
            if(arrangement.charAt(i)=='('){ // 쇠막대기 오픈
                stack.add('(');
            }
            else if(arrangement.charAt(i)==')'){ // 쇠막대기가 닫히면서 나머지 조각 추
                answer++;
                stack.pop();
            }
            else if(arrangement.charAt(i)=='0'){ // 레이저일때
                answer+=stack.size();
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println("## solution start ");

        String testCase = "()(((()())(())()))(())";

        int answer = solution(testCase);
        System.out.println("## solution anwer =>  " + answer);

    }
}