package K2.incheol;

import java.util.Stack;

/**
 * @author Incheol Jung
 */
public class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int currentPick = 0;
        Stack<Integer> result = new Stack<>();

        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                currentPick = board[j][moves[i]-1];
                removeCurrentPick(j, moves[i] - 1, board);
                if(currentPick != 0){
                    if(!result.isEmpty() && result.peek() == currentPick){
                        result.pop();
                        answer+=2;
                    }else{
                        result.push(currentPick);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    private void removeCurrentPick(int i, int j, int[][] board){
        board[i][j] = 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4});
        System.out.println("정답 : " + result);
    }
}
