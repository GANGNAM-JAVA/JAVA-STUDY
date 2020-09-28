package K5.junghyunlyoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private final String ENTER = "Enter";
    private final String LEAVE = "Leave";

    public String[] solution(String[] records) {

        List<String> accessRecords = new ArrayList<>();
        Map<String, String> nicknamePerId = new HashMap<>();

        for (String record : records) {
            String[] splitedRecord = record.split(" ");
            String accessType = splitedRecord[0];
            String id = splitedRecord[1];

            if (accessType.startsWith(ENTER) || accessType.startsWith(LEAVE)) {
                accessRecords.add(accessType + " " + id);
            }

            if (!accessType.startsWith(LEAVE)) {
                String nickname = splitedRecord[2];
                nicknamePerId.put(id, nickname);
            }
        }

        List<String> answer = new ArrayList<>();

        for (String accessRecord : accessRecords) {
            String[] splitedRecord = accessRecord.split(" ");
            String accessType = splitedRecord[0];
            String id = splitedRecord[1];

            answer.add(nicknamePerId.get(id) + "님이" + this.getAccessString(accessType));
        }

        return answer.toArray(new String[0]);
    }

    private String getAccessString(String accessType) {
        return accessType.equals(ENTER) ? " 들어왔습니다." : " 나갔습니다.";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        String[] myResult = solution.solution(input);

        for (String s : result) {
            System.out.println(s);
        }

        System.out.println();

        for (String s : myResult) {
            System.out.println(s);
        }


    }
}
