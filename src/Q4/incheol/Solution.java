package Q4.incheol;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Incheol Jung
 */
public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int task : priorities)
            priorityQueue.add(task);

        while(!priorityQueue.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorityQueue.peek() == priorities[i]) {
                    if(i == location) return answer;
                    priorityQueue.poll();
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int count = sol.solution(new int[] {1, 1, 9, 1, 1, 1}, 0);

        System.out.println(count);
    }
}
