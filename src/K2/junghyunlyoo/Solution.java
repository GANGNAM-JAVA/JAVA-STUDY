package K2.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-08-29
 * @DESCRIPTION
 */

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        final int EMPTY_GRID = 0;
        int sideLength = board.length;
        int disappearedDollCount = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < sideLength; i++) {
                int selectedDoll = board[i][move - 1];

                if (selectedDoll == EMPTY_GRID) {
                    continue;
                }

                board[i][move - 1] = EMPTY_GRID;

                if (basket.isEmpty() || basket.peek() != selectedDoll) {
                    basket.push(selectedDoll);
                } else {
                    basket.pop();
                    disappearedDollCount += 2;
                }
                break;
            }
        }

        return disappearedDollCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int result = solution.solution(board, moves);
        System.out.println("result :: " + result + " " + (result == 4));
    }
}