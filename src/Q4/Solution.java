package Q4;
/*
 * @USER JungHyun
 * @DATE 2020-07-02
 * @DESCRIPTION
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static public int solution(int[] priorities, int location) {
        int answer = 0;

        //priorities 배열을 모두 queue에 저장 -> O(n)
        Queue<Integer> queue = new LinkedList<>();
        for (int pri : priorities) {
            queue.add(pri);
        }

        //priorities 배열을 오름차순 정렬(DualPivotQuicksort) -> O(nlog(n))
        Arrays.sort(priorities);

        //오름차순 정렬된 배열의 가장 마지막 인덱스
        int lastIndex = priorities.length - 1;

        //<큐에서 꺼낸 값>과 <오름차순 정렬된 배열의 가장 큰 수>가 같은지 비교
        while (!queue.isEmpty()) {
            int currentValue = queue.poll();

            //큐에서 값을 하나씩 꺼내면서
            //해당 값의 위치를 한칸씩 앞쪽으로 조정
            location--;

            //큐에서 꺼낸 값이 오름차순된 배열의 가장 큰 값과 같은지 여부
            if (currentValue == priorities[lastIndex - answer]) {
                answer++;

                //값도 같고 해당 값의 인덱스도 맨 앞일 경우 -> 원하는 값의 위치를 찾음
                if (location < 0) {
                    break;
                }
            } else {
                //큐에서 꺼낸 값을 맨 뒤로 보냄
                queue.add(currentValue);
                if (location < 0) {
                    location = queue.size() - 1;
                }
            }
        }
        return answer;
    }
}
