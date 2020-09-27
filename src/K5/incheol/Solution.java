package K5.incheol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Incheol Jung
 */
public class Solution {
    public static Map<String, String> userNameMap = new HashMap<>();

    static class History{
        private String id;
        private Action action;

        public History(String id, Action action) {
            this.id = id;
            this.action = action;
        }

        public static History createBy(String str){
            String[] arr = str.split(" ");
            Action action = arr.length > 1 ? Action.findAction(arr[0].toLowerCase()) : null;
            String id = arr.length > 1 ? arr[1] : "";
            String name = arr.length > 2 ? arr[2] : "";

            History history = new History(id, action);
            updateUserNameMap(history, name);

            return history;
        }

        public static void updateUserNameMap(History history, String name){
            switch (history.action){
                case Enter :
                case Change:
                    userNameMap.put(history.id, name);
            }
        }

        public String getRecord() {
            return userNameMap.get(this.id) + "님이 " + this.action.getDisplayName();
        }
    }

    public enum Action {
        Enter("enter", "들어왔습니다."),
        Leave("leave", "나갔습니다."),
        Change("change", "변경되었습니다.");

        private String value;
        private String displayValue;

        Action(String value, String displayValue){
            this.value = value;
            this.displayValue = displayValue;
        }

        public static Action findAction(String value){
            return Arrays.stream(values()).filter(i -> i.getValue().equals(value)).findFirst().orElseThrow(RuntimeException::new);
        }

        public String getValue() {
            return this.value;
        }

        public boolean isMove(){
            return this.value.equals(Enter.value) || this.value.equals(Leave.value);
        }

        public String getDisplayName() {
            return this.displayValue;
        }
    }

    public String[] solution(String[] record) {
        List<History> histories = new ArrayList<>();
        for(String eachRecord : record){
            histories.add(History.createBy(eachRecord));
        }
        return histories.stream().filter(history -> history.action.isMove()).map(History::getRecord).toArray(String[]::new);
    }

    // 테스트 결과
    //테스트 1 〉	통과 (28.00ms, 54.3MB)
    //테스트 2 〉	통과 (23.90ms, 53.8MB)
    //테스트 3 〉	통과 (35.63ms, 53.9MB)
    //테스트 4 〉	통과 (22.78ms, 52.5MB)
    //테스트 5 〉	통과 (35.61ms, 54.8MB)
    //테스트 6 〉	통과 (40.75ms, 55.4MB)
    //테스트 7 〉	통과 (40.41ms, 54.9MB)
    //테스트 8 〉	통과 (47.06ms, 54.4MB)
    //테스트 9 〉	통과 (47.99ms, 55.7MB)
    //테스트 10 〉	통과 (40.50ms, 55.8MB)
    //테스트 11 〉	통과 (36.04ms, 55.1MB)
    //테스트 12 〉	통과 (27.97ms, 53.9MB)
    //테스트 13 〉	통과 (53.75ms, 54.4MB)
    //테스트 14 〉	통과 (39.36ms, 54.5MB)
    //테스트 15 〉	통과 (15.73ms, 53.3MB)
    //테스트 16 〉	통과 (18.29ms, 53.3MB)
    //테스트 17 〉	통과 (26.22ms, 53.3MB)
    //테스트 18 〉	통과 (18.89ms, 53.4MB)
    //테스트 19 〉	통과 (43.18ms, 54.6MB)
    //테스트 20 〉	통과 (35.46ms, 55.3MB)
    //테스트 21 〉	통과 (35.87ms, 55.6MB)
    //테스트 22 〉	통과 (48.71ms, 55.3MB)
    //테스트 23 〉	통과 (49.67ms, 55.8MB)
    //테스트 24 〉	통과 (47.98ms, 55.3MB)
    //테스트 25 〉	통과 (336.16ms, 158MB)
    //테스트 26 〉	통과 (400.46ms, 163MB)
    //테스트 27 〉	통과 (469.24ms, 166MB)
    //테스트 28 〉	통과 (445.36ms, 168MB)
    //테스트 29 〉	통과 (419.70ms, 167MB)
    //테스트 30 〉	통과 (399.68ms, 164MB)
    //테스트 31 〉	통과 (373.64ms, 173MB)
    //테스트 32 〉	통과 (328.89ms, 149MB)
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = sol.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for(String str : arr){
            System.out.println(str);
        }
    }
}
