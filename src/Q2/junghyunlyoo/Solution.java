package Q2.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-06-18
 * @DESCRIPTION
 */

import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        //무조건 HashMap을 사용하여야 하기 때문에, Map 인터페이스를 사용하지 않고 HashMap으로 타입 정의
        HashMap<String, Integer> map = convertArrayToHashMap(clothes);

        return getSumOfWearCases(map);
    }

    private HashMap<String, Integer> convertArrayToHashMap(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        //for -> O(n)
        for (String[] cloth : clothes) {
            String clothType = cloth[1];
            map.put(clothType, map.getOrDefault(clothType, 0) + 1);//HashMap put -> O(1)
        }

        return map;
    }

    private int getSumOfWearCases(HashMap<String, Integer> map) {
        int answer = 1;

        //for -> O(n)
        for (Integer value : map.values()) {
            //모든 착용 케이스 계산
            answer *= (value + 1);
        }
        //test

        //아무것도 착용하지 않은 경우 제외
        return --answer;
    }
}
