package Q1.yongseon;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantsMap = new HashMap<String, Integer>();
        
        for (String participantName : participant) {
            participantsMap.put(participantName, participantsMap.getOrDefault(participantName, 0) + 1);
        }
        
        for (String completionName : completion) {
            participantsMap.put(completionName, participantsMap.get(completionName) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : participantsMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return null;
    }
}
