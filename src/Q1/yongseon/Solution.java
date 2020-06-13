package Q1.yongseon;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantsMap = new HashMap<String, Integer>();
        
        for (String pt : participant) {
            participantsMap.put(pt, participantsMap.getOrDefault(pt, 0) + 1);
        }
        
        for (String cmp : completion) {
            participantsMap.put(cmp, participantsMap.get(cmp) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : participantsMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return null;
    }
}
