package K4;
/*
 * @USER JungHyun
 * @DATE 2020-09-13
 * @DESCRIPTION
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int CACHE_HIT_PROCESS_TIME = 1;
    private static final int CACHE_MISS_PROCESS_TIME = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * CACHE_MISS_PROCESS_TIME;
        }
        Queue<String> queue = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (queue.contains(city)) {
                answer += CACHE_HIT_PROCESS_TIME;
                queue.remove(city);
            } else {
                answer += CACHE_MISS_PROCESS_TIME;
            }
            queue.add(city);
            if (cacheSize < queue.size()) {
                queue.remove();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result1 = solution.solution(3, new String[]{"jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println("result1 :: " + result1);
    }
}
