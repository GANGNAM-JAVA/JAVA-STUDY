package K2.kyunghee;

import java.util.*;

public class Solution {
    public int solution(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(Integer move : moves) {
            int moveIndex = move -1;
            for(int i = 0; i< board.length; i++) {
                int k = board[i][moveIndex];
                if(k == 0) continue;
                if(!stack.empty() && stack.peek() == k) {
                    stack.pop();
                    answer++;
                } else {
                    stack.push(k);
                }
                board[i][moveIndex] = 0;
                break;
            }
        }
        return answer * 2;
    }
}
