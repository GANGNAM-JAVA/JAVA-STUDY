package Q5;

/*
 * @USER JungHyun
 * @DATE 2020-07-12
 * @DESCRIPTION
 */

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("()") == 0);
        System.out.println(solution("(())") == 2);
        System.out.println(solution("(())()") == 2);
        System.out.println(solution("(()())") == 3);
        System.out.println(solution("(()())(())") == 5);
        System.out.println(solution("(()())(())()") == 5);
        System.out.println(solution("((()())(())())") == 10);
        System.out.println(solution("(((()())(())()))") == 15);
        System.out.println(solution("()(((()())(())()))") == 15);
        System.out.println(solution("()(((()())(())()))(())") == 17);
    }

    public static int solution(String arrangement) {
        char[] arrangementCharArray = arrangement.toCharArray();
        //한 묶음 내의 총 조각 수
        int slicedPiecesCount = 0;
        //모든 묶음의 총 조각 수
        int allSlicedPiecesCount = 0;
        //조각을 담는 스택 인스턴스
        Stack<Character> stack = new Stack<>();
        //O(n)
        for (int i = 0; i < arrangementCharArray.length; i++) {
            char currentChar = arrangementCharArray[i];
            if (stack.empty()) {
                //스택이 비었을 경우
                //아무 조건 없이 스택에 현재 문자 추가
                stack.add(currentChar);
            } else {
                //스택에 값이 있을 경우
                char topCharInStack = stack.peek();
                if (topCharInStack == '(' && currentChar == ')') {
                    //스택의 최상단 값이 ( 이고 반복중인 현재 문자가 )일 경우
                    //스택의 최상단 값 제거
                    stack.pop();
                    //반복중인 현재 문자의 바로 전 문자가 (일 경우, 즉 레이저가 발사될 경우
                    //한 묶음 내의 총 조각 수에 현재 작업중인 막대기 수 저장
                    //아닌 경우 작업이 끝난 막대기 1개 저장
                    char prevChar = arrangementCharArray[i - 1];
                    slicedPiecesCount += prevChar == '(' ? stack.size() : 1;
                    //스택이 비었고 한 묶음 내의 총 조각이 있을 경우
                    //모든 묶음의 총 조각 수에 작업된 한 묶음 내의 총 조각 수 저장
                    //한 묶음 내의 총 조각수 초기화
                    if (stack.empty() && slicedPiecesCount != 0) {
                        allSlicedPiecesCount += slicedPiecesCount;
                        slicedPiecesCount = 0;
                    }
                } else {
                    //스택의 최상단 값이 (가 아니고 반복중인 현재 문자도 )가 아닐 경우
                    //스택에 현재 문자 저장
                    stack.add(currentChar);
                }
            }
        }
        return allSlicedPiecesCount;
    }
}
