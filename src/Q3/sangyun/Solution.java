package Q3.sangyun;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            float remainTask = 100-progresses[i];
            int toDoTask =  (int)Math.ceil(remainTask/speeds[i]);
            q.offer(toDoTask);
        }

        while(!q.isEmpty()) {
            int curDay = q.poll();
            int count = 1;
            while(!q.isEmpty() && curDay >= q.peek()) {
                q.poll();
                count++;
            }
            list.add(count);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}