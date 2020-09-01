package K2.jisoo;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/64061
class Solution {
    public static void main(String[] args) {
        int[][] board =
                {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> check = new Stack<>();

        for(int i=0 ; i<moves.length ; i++) {
            int targetIndex = moves[i] - 1;
            for(int j=0 ; j<board.length ; j++) {
                if(board[j][targetIndex] > 0) {
                    if(!check.isEmpty() && check.peek() == board[j][targetIndex]) {
                        answer++;
                        check.pop();
                    } else {
                        check.push(board[j][targetIndex]);
                        board[j][targetIndex] = 0;
                    }
                    break;
                }
            }
        }
        return answer * 2;
    }
}

