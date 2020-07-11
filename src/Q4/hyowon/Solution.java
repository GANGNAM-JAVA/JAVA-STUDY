package Q4.hyowon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {2, 1, 3, 2};
        int test = s.solution(arr, 2);
        System.out.println(test); // 1

        int[] arr2 = {1, 1, 9, 1, 1, 1};
        int test2 = s.solution(arr2, 0);
        System.out.println(test2); // 5

        System.out.println();
    }

    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList();
        int locationNumber = priorities[location];
        /*
         * O(n)
         * queue에 배열을 넣고 queue를 돌면서 프린트된 수는 제거할 건데,
         * 그렇게 되면 점찍어둔 숫자(location)의 위치가 흐트러집니다.
         * 우선순위는 1-9 사이이니 그보다 큰 수인 10을 더해 숫자를 표시해둡니다.
         * */
        for (int i = 0; i < priorities.length; i++) {
            if (i == location) {
                q.add(priorities[i] + 10);
            } else if (priorities[i] >= locationNumber) {
                q.add(priorities[i]);
            } else {
            }
        }

        // O(n log n)
        Arrays.sort(priorities);

        int lastIndex = priorities.length - 1;
        // O(n!)
        while (q.size() != 0) {
            if (q.peek() < 10 && q.peek() == priorities[lastIndex]) { // 큐 맨위의 값과 큐 내의 가장 큰 수를 비교
                q.remove();
                --lastIndex;
            } else if (q.peek() >= 10 && (q.peek() - 10) == priorities[lastIndex]) { // 점찍어둔 수가 큐 내에서 가장 크면 큐에서 제거 후 종료
                return priorities.length - lastIndex; // 5 - 4
            } else {
                q.add(q.peek());
                q.remove();
            }
        }

        return priorities.length - lastIndex;
    }
}
