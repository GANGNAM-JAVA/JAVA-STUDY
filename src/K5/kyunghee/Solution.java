import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        List<String[]> temp = new LinkedList<>();

        for (String records : record) {
            String[] keyWord = records.split(" ");
            if (keyWord[0].equals("Enter")) {
                users.put(keyWord[1], keyWord[2]);
                temp.add(keyWord);

            } else if (keyWord[0].equals("Change")) {
                users.put(keyWord[1], keyWord[2]);

            } else {
                temp.add(keyWord);
            }
        }

        String[] answer = new String[temp.size()];
        int index = 0;
        for (String[] keyWords : temp) {
            String nickName = users.get(keyWords[1]);
            if (keyWords[0].equals("Enter")) {
                answer[index++] = nickName + "님이 들어왔습니다.";
            } else {
                answer[index++] = nickName + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}