package programmers;

import java.util.HashMap;
import java.util.Map;

/*
https://programmers.co.kr/learn/courses/30/lessons/42578
프로그래머스 : 해시 / 위장
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때
서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class Solution {
    public static void main(String[] args) {
        String[][] testcase1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution(testcase1));

        String[][] testcase2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };
        System.out.println(solution(testcase2));

    }
    public static int solution(String[][] clothes) {
        Map<String, Integer> countByCategory = new HashMap<>();
        int answer = 1;
        // 반복문1 : O(N)
        for(String[] args : clothes) {
            // 카테고리 별로 의상 가짓 수를 더한다.
            countByCategory.put(args[1], countByCategory.getOrDefault(args[1], 0) + 1);
        }

        // stream 사용하면 시간이 훨씬 더 걸림. for문의 경우 평균 0.80ms, stream쓰면 평균 3ms
        //answer = countByCategory.values().stream().reduce(1, (a,b) -> a * (b + 1));

        // 반복문2 : O(N)
        for(Map.Entry<String, Integer> entry : countByCategory.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        // 최종 시간복잡도 O(2N) -> O(N)
        return answer - 1;
    }
}
