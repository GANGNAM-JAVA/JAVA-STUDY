import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantCountMap = new HashMap<>();

        for(int i=0 ; i<participant.length ; i++) {
            participantCountMap.put(participant[i], participantCountMap.getOrDefault(participant[i], 0) + 1);
        }

        for(int i=0 ; i<completion.length ; i++) {
            participantCountMap.put(completion[i], participantCountMap.get(completion[i]) + 1);
        }

        for (Map.Entry<String, Integer> entry : participantCountMap.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return null;
    }
}