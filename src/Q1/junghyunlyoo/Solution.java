package Q1.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-06-10
 * @DESCRIPTION
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
    }

    private static String solution(String[] participant, String[] completion) {
        //참가자 데이터 Map에 저장
        Map<String, Integer> participantMap = new HashMap<>();
        for (String s : participant) {
            //key : 참가자 이름
            //value : 이름당 참가자 수(중복 수 계산)
            if (participantMap.containsKey(s)) {
                Integer value = participantMap.get(s);
                participantMap.put(s, value + 1);
            } else {
                participantMap.put(s, 1);
            }
        }

        //참가자 Map에서 완주자 제거
        for (String s : completion) {
            Integer value = participantMap.get(s);
            //중복이 없을 경우 -> 제거
            //중복이 있을 경우 -> value -1
            if (value == 1) {
                participantMap.remove(s);
            } else {
                participantMap.put(s, value - 1);
            }
        }
        String result = null;
        Set<String> strings = participantMap.keySet();
        for (String string : strings) {
            result = string;
        }
        return result;
    }
}
