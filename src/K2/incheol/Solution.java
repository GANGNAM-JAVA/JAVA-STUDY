package K2.incheol;

import java.util.Stack;

/**
 * @author Incheol Jung
 */
public class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();

        for(int i = 0; i < board.length; i++){
            for(int j=0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                int currentPick = board[j][moves[i]-1];
                if(currentPick != 0){
                    System.out.println("currentPick!! === " + currentPick);
                    if(!result.isEmpty() && result.peek() == currentPick){
//                        System.out.println("currentPick!! === " + currentPick);
                        result.pop();
                        answer+=2;
                    }else{
                        result.push(currentPick);
                    }
                    break;
                }
                board[j][moves[i]-1] = 0;
            }
        }

        while(!result.isEmpty()){
            System.out.println(result.pop());
        }

        for(int i = 0; i < board.length; i++){
            for(int j=0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4});
        System.out.println("°á°ú°ª : " + result);
    }
}
