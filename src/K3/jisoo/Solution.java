package K3.jisoo;

import java.util.*;

// FIXME : 수정 필요. 런타임 에러
// https://programmers.co.kr/learn/courses/30/lessons/64065
public class Solution {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
//        System.out.println(Arrays.toString(solution2("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
//        System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
//        System.out.println(Arrays.toString(solution("{{123}}")));
//        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
//        System.out.println(Arrays.toString(solution("{{50000},{1,50000}}")));
    }

    public static int[] solution(String s) {
        // 1. 원소의 갯수가 1개인 것부터 2.. 3.... n개인 것 까지 정렬한다.
        s = s.replaceAll("\\{", "");
        s = s.replaceAll("\\}\\}", "");
        String[] elements = s.split("\\},");

        if (elements.length > 1)
            Arrays.sort(elements, (s1, s2) -> s1.length() - s2.length()); // 문자열 길이 기준으로 오름차순 정렬

        // 2. 1개인 것부터 answer 배열에 넣고, 2개인 것에는 1개 원소를 빼고, 3개인 것에는 2개 원소를 빼고...
        int[] answer = new int[elements.length];

        // O(NlogN)
        for (int i = 1; i <= elements.length; i++) {
            String sub = elements[i - 1].replaceAll(",", "");
            answer[i - 1] = Integer.parseInt(sub);
            for (int j = i; j < elements.length; j++) {
                elements[j] = elements[j].replaceAll(sub, "");
            }
        }
        return answer;
    }

    // using map
    public static int[] solution2(String s) {
        Map<Integer, Integer> checkCount = new HashMap<>();
        s = s.replaceAll("\\{", "").replaceAll("\\}", "");
        String[] elements = s.split(",");

        // O(N)
        for(int i=0 ; i<elements.length ; i++) {
            int num = Integer.parseInt(elements[i]);
            checkCount.put(num, checkCount.getOrDefault(num, 0) + 1);
        }
        int[] answer = new int[checkCount.size()];

        List<Map.Entry<Integer, Integer>> mapToList = new LinkedList<>(checkCount.entrySet());
        mapToList.sort(Map.Entry.comparingByValue((v1, v2) -> v2 - v1));

        int i = 0;

        // O(N)
        for(Map.Entry<Integer, Integer> entry : mapToList) {
            answer[i++] = entry.getKey();
        }
        return answer;
    }
}

