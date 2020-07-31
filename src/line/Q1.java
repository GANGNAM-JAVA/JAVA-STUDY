package line;

import java.util.Stack;

/**
 * @author Incheol Jung
 */
public class Q1 {

    enum AtoZ{

    }

    public int solution(String s) {
        int answer = 0;
        char[] charArray = s.toCharArray();
        Stack<Character> charStack = new Stack<>();

        for(char character : charArray){
            if(character == 'a' || character == 'z'){
                if(charStack.empty()) charStack.push(character);
                else{
                    if(charStack.pop() != character) {
                        answer++;
                    }
                    charStack.push(character);
                }
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Q1");
        Q1 sol = new Q1();
        System.out.println(sol.solution("zabzczxa"));
    }
}
