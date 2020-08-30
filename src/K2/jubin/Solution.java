package K2.jubin;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int board_len = board[0].length;
        Map<Integer, Stack<Integer>> crain_map = new HashMap<>();

        // 세로열을 각 정의합니다.
        for(int i=0; i<board_len; i++){
            Stack<Integer> row = new Stack<>();

            for(int j=board_len-1; j>=0; j--){
                if(board[j][i] != 0)
                    row.push(board[j][i]);
            }
            crain_map.put(i+1, row);
        }


        Stack<Integer> basket = new Stack();
        basket.push(0);

        for(int move: moves){
            Stack<Integer> doll_stack = crain_map.get(move);
            if(!doll_stack.empty()){
                int doll = doll_stack.pop();
                if (basket.peek() == doll){
                    basket.pop();
                    answer += 2;
                }else{
                    basket.push(doll);
                }
            }
        }
        return answer;

    }
}