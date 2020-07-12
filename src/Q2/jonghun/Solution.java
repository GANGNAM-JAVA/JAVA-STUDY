package Q2.jonghun;

import java.util.HashMap;

public class Solution {

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) // 의상의 종류 체크
                map.replace(clothes[i][1], map.get(clothes[i][1]) + 1); // 해당 의상의 종류에 개수 추가
            else
                map.put(clothes[i][1], 1); // 의상의 종류 추
        }

        int answer = 1; // 최소 1개는 선택해야하니까 초기값 = 1
        for (int value : map.values()) {
            answer *= (value + 1); // 해당 의상 종류의 개수 + 아무것도 선택하지 않았을 때 경우 추
        }
        answer -= 1; // 위의 초기 경우 경우 빼기

        return answer;
    }

    public static void main(String[] args) {

        System.out.println("## solution start ");
        String[][] clothies = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"} , {"킹왕짱","body"}};
        int answer = solution(clothies);
        System.out.println("## solution anwer =>  " + answer);

    }
}
