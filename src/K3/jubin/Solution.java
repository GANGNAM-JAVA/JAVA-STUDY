package K3.jubin;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        String[] splitedStr =
                s.replace("{","").replaceAll("},","-").replace("}","").split("-");

        ArrayList<Integer> answerList = new ArrayList<>();
        Arrays.sort(splitedStr, (a, b)->Integer.compare(a.length(), b.length()));

        for(String tuple: splitedStr){
            String[] tuple_item = tuple.split(",");
            for(String item: tuple_item){
                int num = Integer.valueOf(item);
                if (!answerList.contains(num)){
                    answerList.add(num);
                }
            }
        }

        int [] answer = new int[answerList.size()];
        for(int i=0 ; i<answerList.size() ; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}