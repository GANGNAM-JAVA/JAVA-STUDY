package Q1.incheol;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> completionCountMap = new HashMap<String, Integer>();

        for(String participantName : participant)
            completionCountMap.put(participantName, completionCountMap.getOrDefault(participantName, 0) + 1);

        for(String completionName : completion)
            completionCountMap.put(completionName, completionCountMap.get(completionName) - 1);

        answer = completionCountMap.entrySet()
                .stream()
                .filter(completionCount -> completionCount.getValue() != 0)
                .findFirst()
                .map(completionCount -> completionCount.getKey())
                .orElse("");

        return answer;
    }

    public static void main(String[] args) {
        String[] participants = {"mislav", "stanko", "mislav", "ana"};
        String[] completions = {"stanko", "ana", "mislav"};

        Solution solution = new Solution();
        String participantName = solution.solution(participants, completions);
        System.out.println("participantName = " + participantName);
    }
}

