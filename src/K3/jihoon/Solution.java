package K3.jihoon;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "{|}|,", false);
        Map<Integer, Integer> splitMap = new HashMap<Integer, Integer>();
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            splitMap.merge(Integer.parseInt(str), 1, Integer::sum);
        }

        List<Integer> sortedList = splitMap.entrySet().
                stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                map(e -> e.getKey()).
                collect(Collectors.toList());

        int[] answer = new int[sortedList.size()];
        for(int i = 0; i < sortedList.size(); i++)
            answer[i] = sortedList.get(i);

        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
	}
}

/*
테스트 1 〉	통과 (7.73ms, 68.9MB)
테스트 2 〉	통과 (5.31ms, 69.5MB)
테스트 3 〉	통과 (4.79ms, 69.2MB)
테스트 4 〉	통과 (7.74ms, 69.6MB)
테스트 5 〉	통과 (8.94ms, 69.1MB)
테스트 6 〉	통과 (11.86ms, 69.2MB)
테스트 7 〉	통과 (38.96ms, 71.3MB)
테스트 8 〉	통과 (53.13ms, 76MB)
테스트 9 〉	통과 (41.65ms, 73.5MB)
테스트 10 〉	통과 (57.43ms, 77MB)
테스트 11 〉	통과 (60.69ms, 77.3MB)
테스트 12 〉	통과 (78.43ms, 79.2MB)
테스트 13 〉	통과 (73.69ms, 79.1MB)
테스트 14 〉	통과 (75.28ms, 79.9MB)
테스트 15 〉	통과 (4.81ms, 70.5MB)
*/