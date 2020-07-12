package Q3.jisoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String [] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))); // 2, 1
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55, 90}, new int[]{1, 30, 5, 1}))); // 2, 1, 1
        System.out.println(Arrays.toString(solution(new int[]{10, 20, 30, 40}, new int[]{40, 30, 20, 10}))); // 2, 1, 1
        System.out.println(Arrays.toString(solution(new int[]{10, 20, 30, 40}, new int[]{40, 30, 20, 10}))); // 2, 1, 1
        System.out.println(Arrays.toString(solution(new int[]{99, 97, 95, 96, 93, 92, 96}, new int[]{1, 1, 1, 1, 1, 1, 1}))); // 1, 1, 2, 1, 2
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        int[] dayArray = new int[length];

        // O(N)
        // dayArray 배열에 각 progresses 별 남은 작업량을 저장한다.
        for(int i=0 ; i<length ; i++) {
            int rest = (100 - progresses[i]);
            dayArray[i] = rest / speeds[i];
            if(rest % speeds[i] > 0) dayArray[i]++;
        }

        // O(N)
        List<Integer> result = new ArrayList<>();
        int max = dayArray[0];
        int count = 1;

        // 초기 max값을 설정하고, 다음 원소가 max값보다 크면 기존 count값을 추가한다. 단 for문이 끝나면 마지막 count값을 추가한다.
        for(int i=1 ; i<length ; i++) {
            if(dayArray[i] > max) {
                result.add(count);
                count = 1;
                max = dayArray[i];
            } else {
                count++;
            }
        }

        result.add(count); // 마지막 인덱스에서는 마지막 count 값을 어떠한 경우라도 add 해야함.

        // stream 이용하면 기존 1.70ms - 7ms로 느려짐.
        // O(N)
        // 최종 O(3N) -> O(N)
        return result.stream().mapToInt(i->i).toArray();
    }
}
