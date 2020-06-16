import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> tmp = new HashMap<>();

        for (String s : participant) {
            tmp.put(s, tmp.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            tmp.put(s, tmp.get(s) + 1);
        }

        for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        return tmp.entrySet()
                .stream()
                .filter((entry) -> entry.getValue() % 2 != 0)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}