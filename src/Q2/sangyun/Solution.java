package Q2.sangyun;

import java.util.*;


class Solution {
    public int solution(String[][] clothes) {

        int answer = 1;
        Map<String,Integer> countByCategory = new HashMap<>();

        for(String [] clothe : clothes) {
            countByCategory.put(clothe[1],countByCategory.getOrDefault(clothe[1],0) + 1);
        }

        for(Integer count : countByCategory.values()) {
            answer *= count + 1;
        }


        return answer - 1;
    }
}
