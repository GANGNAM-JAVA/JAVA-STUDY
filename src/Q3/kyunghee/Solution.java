
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();

        for(int i = 0; i < progresses.length; i++) {
            // 잔업량 백분율 구하기
            // 잔업량 / 속도 = 현재까지 작업된 기준  (100% 기준)
            queue.add(getOverTimeWork(progresses[i], speeds[i]));
        }

        int standard = queue.poll();
        int count = 1;
        // 0이 될 경우 배포 아니면 +1 다음날 배포
        // 기준치 보다 작은 수가 있으면 배포 기능 추가
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int num = queue.poll();
            if(standard >= num) {
                count++;
            } else {
                result.add(count);
                count = 1;
                standard = num;
            }
        }
        result.add(count);

        int[] answer = new int[result.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;

    }
    public int getOverTimeWork(int progress, int speed) {
        int overtime = (100 -  progress) / speed;
        return (100 - progress) % speed == 0 ? overtime : overtime + 1;
    }


      public static void main(String[] args) {
          int[] progresses = new int[] {93,30,55};
          int[] speeds = new int[] {1,30,5};

          Solution solution = new Solution();

          solution.solution(progresses, speeds);
      }

}
