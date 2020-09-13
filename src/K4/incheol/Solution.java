package K4.incheol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Incheol Jung
 */
public class Solution {

    class LRUCache {
        private int cacheSize;
        private List<String> items = new ArrayList<>();
        private int executeTime;

        public LRUCache(int cacheSize) {
            this.cacheSize = cacheSize;
        }

        // 문자열 검색
        public void find(String value) {
            int currentIdx = items.indexOf(value);
            updateExecuteTime(currentIdx != -1);
            updateItems(currentIdx, cacheSize, value);
        }

        // 캐시 사이즈가 0이 아닐 경우에만 컬렉션에 아이템 추가
        private void updateItems(int currentIdx, int cacheSize, String value) {
            if (currentIdx != -1) {
                items.remove(currentIdx);
            } else if (!items.isEmpty() && items.size() >= cacheSize) {
                items.remove(0);
            }

            if (cacheSize != 0) {
                items.add(value);
            }
        }

        // 아이템 존재 여부에 따라 실행 시간 증가
        private void updateExecuteTime(boolean isExist) {
            if (isExist) {
                executeTime++;
            } else {
                executeTime = executeTime + 5;
            }
        }
    }

    // 루프문으로 도시들을 순회하면서 실행값 증가
    public int solution(int cacheSize, String[] cities) {
        LRUCache bucket = new LRUCache(cacheSize);
        for (String city : cities) {
            bucket.find(city.toLowerCase());
        }

        return bucket.executeTime;
    }

    //테스트 1 〉	통과 (0.32ms, 51.8MB)
    //테스트 2 〉	통과 (0.35ms, 53MB)
    //테스트 3 〉	통과 (0.32ms, 53.1MB)
    //테스트 4 〉	통과 (0.33ms, 52.9MB)
    //테스트 5 〉	통과 (0.23ms, 52.3MB)
    //테스트 6 〉	통과 (0.33ms, 52.2MB)
    //테스트 7 〉	통과 (0.33ms, 52.9MB)
    //테스트 8 〉	통과 (0.41ms, 52.1MB)
    //테스트 9 〉	통과 (0.34ms, 52.4MB)
    //테스트 10 〉	통과 (0.64ms, 51.9MB)
    //테스트 11 〉	통과 (47.79ms, 81.4MB)
    //테스트 12 〉	통과 (0.57ms, 52.1MB)
    //테스트 13 〉	통과 (1.01ms, 53.9MB)
    //테스트 14 〉	통과 (1.24ms, 52MB)
    //테스트 15 〉	통과 (1.55ms, 53.4MB)
    //테스트 16 〉	통과 (3.95ms, 53.1MB)
    //테스트 17 〉	통과 (2.59ms, 53.5MB)
    //테스트 18 〉	통과 (4.09ms, 52.7MB)
    //테스트 19 〉	통과 (4.42ms, 52.9MB)
    //테스트 20 〉	통과 (3.75ms, 52.4MB)
    public static void main(String[] args) {
        Solution sol = new Solution();
        int executeTime = sol.solution(0, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
        System.out.println("executeTime = " + executeTime);
    }
}
