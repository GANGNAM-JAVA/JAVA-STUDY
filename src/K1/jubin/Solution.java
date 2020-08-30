package K1.jubin;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static Map makeKeypadMap(){
        Map<Integer, Integer[]> keyPad = new HashMap<>();
        keyPad.put(1, new Integer[]{0, 0});
        keyPad.put(2, new Integer[]{0, 1});
        keyPad.put(3, new Integer[]{0, 2});
        keyPad.put(4, new Integer[]{1, 0});
        keyPad.put(5, new Integer[]{1, 1});
        keyPad.put(6, new Integer[]{1, 2});
        keyPad.put(7, new Integer[]{2, 0});
        keyPad.put(8, new Integer[]{2, 1});
        keyPad.put(9, new Integer[]{2, 2});
        keyPad.put(0, new Integer[]{3, 1});

        return keyPad;
    }

    public String solution(int[] numbers, String hand) {
        Map<Integer, Integer[]> keyPad = makeKeypadMap();
        String answer = "";
        Integer[] right = {3, 2};
        Integer[] left = {3, 0};

        for(int number: numbers){
            if(number == 1 || number == 4 || number == 7 ) {
                answer += "L";
                left = keyPad.get(number);
            }else if(number == 3 || number == 6 || number == 9 ){
                answer += "R";
                right = keyPad.get(number);
            }else{
                Integer[] target = keyPad.get(number);
                int right_distance = Math.abs(right[0]-target[0]) + Math.abs(right[1]-target[1]);
                int left_distance = Math.abs(left[0]-target[0]) + Math.abs(left[1]-target[1]);
                if(right_distance > left_distance) {
                    answer += "L";
                    left = target;
                }else if (left_distance > right_distance){
                    answer += "R";
                    right = target;
                }else{
                    if(hand.equals("right")){
                        answer += "R";
                        right = target;
                    }else{
                        answer += "L";
                        left = target;
                    }
                }
            }
        }
        return answer;
    }
}