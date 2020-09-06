package K2.jihoon;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
		Stack<Integer> resultStack = new Stack<Integer>();

		int stackSize = board.length;
		List<Stack<Integer>> stacks = new ArrayList<>(stackSize);
		for (int j = 0; j < stackSize; j++) {
			stacks.add(new Stack<Integer>());
			for (int i = stackSize - 1; i >= 0 && board[i][j] != 0; i--) {
				stacks.get(j).push(board[i][j]);
			}
		}

		for (int i = 0; i < moves.length; i++) {
			int col = moves[i] - 1;

			if (stacks.get(col).isEmpty()) 
				continue;

			int next = stacks.get(col).pop();

			if (resultStack.isEmpty()) {
				resultStack.push(next);
				continue;
			}
		
			int current = resultStack.peek();
			if (next == current) {
				resultStack.pop();
				answer += 2;
			} else {
				resultStack.push(next);
			}
		}

        return answer;
    }

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};


		Solution s = new Solution();
		System.out.println(s.solution(board, moves));
	}
}
