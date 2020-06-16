package Q1.yongseon;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantsMap = new HashMap<String, Integer>();
        
        for (String name : participant) {
            participantsMap.put(name, participantsMap.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            participantsMap.put(name, participantsMap.get(name) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : participantsMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return null;
    }
}
