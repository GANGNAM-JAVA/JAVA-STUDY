package Q4.jisoo;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1},0));
    }

    // location의 인덱스는 0부터 시작작
    public static int solution(int[] priorities, int location) {
        int count = 0;
        Queue<Map.Entry<Integer, Integer>> q = new LinkedBlockingQueue<>();

        int i = 0;
        for(int priority : priorities) {
            q.add(new AbstractMap.SimpleEntry<>(i++, priority));
        }

        while(!q.isEmpty()) {
            Map.Entry<Integer, Integer> peek = q.remove();
            int index = peek.getKey();
            int priority = peek.getValue();
            boolean chk = false;

            for(Map.Entry<Integer, Integer> element : q) {
                if(element.getValue() > priority) { // 원소중 우선순위가 더 큰값이 나오면
                    q.add(peek); // peek 꺼낸 값을 맨 뒤에 추가한다.
                    chk = true;
                    break;
                }
            }
            if(!chk) { // peek로 꺼낸값의 우선 순위가 제일 클 경우
                count++; // 인쇄 처리하고 count 횟수를 증가시킴
                if(location == index) {
                    return count;
                }
            }
        }
        return -1;
    }
}
