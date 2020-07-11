package camouflage;

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 2차원 배열 담기
        HashMap<String,  Integer> map = new HashMap<String,  Integer>();
        int combination = 1;    // 최소 조합 가능한 반환값

        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1],0) +1);
        }

        for (String key : map.keySet()) {
            combination *= map.get(key)+1;
        }

        return combination-1;
    }
}