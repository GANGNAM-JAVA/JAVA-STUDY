package Q2.incheol;

import java.util.HashMap;
import java.util.Set;

/**
 * @author Incheol Jung
 */
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();

        for(int i =0; i<clothes.length; i++){

            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
        }

        Set<String> keySet = clothesMap.keySet();

        for(String key : keySet) {
            answer *= clothesMap.get(key)+1;
        }

        return answer-1;
    }
}
