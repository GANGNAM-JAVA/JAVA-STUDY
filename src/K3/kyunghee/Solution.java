import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> maps = new HashMap<>();
        Map<Integer, Integer> values = new HashMap<>();

        String[] brackets = s.replace("{", "").replace("}", "").split(",");

        for (String bracket : brackets) {
            int keys = Integer.parseInt(bracket);
            maps.compute(keys, (k, v) -> v == null ? 1 : v + 1);
        }

        maps.forEach((k, v) -> values.put(v, k));

        int number = values.size();
        int[] answer = new int[number];

        for (int i = 1; i <= number; i++) {
            answer[number-i] = values.get(i);
        }

        return answer;
    }
}