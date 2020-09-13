package K5.jihoon;

import java.util.*;

public class Solution {
    public String[] solution(String[] records) {
        Map<String, String> userName = new HashMap<>();
        Map<String, String> message = new HashMap<>();
        message.put("Enter", "님이 들어왔습니다.");
        message.put("Leave", "님이 나갔습니다.");

        for (String record : records) {
            String[] recordSplit = record.split(" ");
            if (recordSplit.length < 3)
                continue;

            String id = recordSplit[1];
            String name = recordSplit[2];
            userName.put(id, name);
        }
        List<String> answerList = new LinkedList<>();
        for (String record : records) {
            String[] recordSplit = record.split(" ");
            String action = recordSplit[0];
            if (action.equals("Change"))
                continue;
            String id = recordSplit[1];
            answerList.add(userName.get(id)  + message.get(action));
        }
        return answerList.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String[] records = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};
        Solution s = new Solution();
        for (String answer : s.solution(records))
            System.out.println(answer);
    }
}

