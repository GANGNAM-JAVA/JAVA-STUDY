package Q1.jonghun;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant); // 이름순 정렬
        Arrays.sort(completion); // 이름순 정렬
        int i =0;
        for(i =0; i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                return participant[i]; // 선수가 더 많기 때문에
            }
        }
        return participant[i]; // 마지막 선수
    }

    public static void main(String[] args) {
        String[] participants = {"leo", "kiki", "eden"};
        String[] completions = {"kiki", "eden"};

        Solution solution = new Solution();
        String participantName = solution.solution(participants, completions);
        System.out.println("## participantName = " + participantName);
    }
}