package Q3.jonghun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<Integer>(); //

        int index = 0;
        int count = 0;

        while(index < progresses.length){
            for(int i = 0; i < progresses.length; i++){
                progresses[i] += speeds[i]; // 하루에 해당 작업속도만큼 진도를 추가한다.
            }

            if(progresses[index] >= 100){ // 작업이 끝난 순간
                while(index < progresses.length && progresses[index] >= 100 ){ // 나머지 작업들도 끝났는지 확인한다.
                    count += 1;
                    index += 1;
                }
                queue.offer(count); // 선입선출 큐에 담는다.
                count = 0;
            }
        }

        int[] answer = new int[queue.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = queue.poll(); // 선입선출 큐에서 꺼낸다.
            System.out.println("# "+ answer[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        int[] answer = solution(progresses, speeds);
        System.out.println("## answer = " + Arrays.toString(answer));
    }
}
