package Q5.incheol;

import java.util.Stack;

/**
 * @author Incheol Jung
 */
public class Solution {
    private enum  Backet{
        OPEN('('),
        CLOSE(')');

        final private char character;

        Backet(char character) {
            this.character = character;
        }

        public char getValue(){
            return this.character;
        }
    }

    public int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == Backet.OPEN.getValue()) {
                st.push(i);
            } else if (arrangement.charAt(i) == Backet.CLOSE.getValue()) {
                if (st.peek() + 1 == i) {
                    st.pop();
                    answer += st.size();
                } else {
                    st.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("()(())"));
    }
}
