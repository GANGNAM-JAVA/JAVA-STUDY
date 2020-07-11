package Q2.hyowon;

import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesQuantity = new HashMap<>();

        for (String[] clothe : clothes) {
            clothesQuantity.put(clothe[1], clothesQuantity.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (String key : clothesQuantity.keySet()) {
            answer *=  (clothesQuantity.get(key) + 1);
        }

        return answer - 1;
    }

}
