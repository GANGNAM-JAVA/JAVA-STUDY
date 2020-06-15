package Q1.sangyun;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String solution(String[] participant, String[] completion) {

        Map<String,Integer> participantList = new HashMap<>();

        for(String person : participant) {
            participantList.put(person, participantList.getOrDefault(person, 0) + 1);
        }

        for(String person : completion) {
            participantList.put(person, participantList.get(person) - 1);
        }

        return participantList.entrySet().stream()
                .filter(person -> person.getValue() != 0)
                .findFirst()
                .map(person -> person.getKey())
                .orElse("");
    }
}

