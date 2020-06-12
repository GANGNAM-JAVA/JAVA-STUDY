package Q1.incheol.sangyun;

import java.util.HashMap;
import java.util.Map;


class Solution {

    public String solution(String[] participant, String[] completion) {

        Map<String,Integer> participantList = new HashMap<>();
        String answer = "";

        for(String person : participant) {
            if(participantList.containsKey(person)) participantList.put(person,participantList.get(person) + 1);
            else participantList.put(person,1);
        }

        for(String person : completion) {
            participantList.put(person, participantList.get(person) - 1);
        }

        for(String key : participantList.keySet()) {
            if(participantList.get(key) == 1) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}