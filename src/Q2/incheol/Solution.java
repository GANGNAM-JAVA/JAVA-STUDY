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

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] clothies = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}, {"suit","body"}, {"pants","bottom"}};
        int answer = sol.solution(clothies);
        System.out.println("## solution anwer =>  " + answer);
    }
}
