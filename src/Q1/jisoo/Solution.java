import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> tmp = new HashMap<>();

        for(int i=0 ; i<participant.length ; i++) {
            tmp.put(participant[i], tmp.getOrDefault(participant[i], 0) + 1);
        }

        for(int i=0 ; i<completion.length ; i++) {
            tmp.put(completion[i], tmp.get(completion[i]) + 1);
        }

        for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return null;
    }
}