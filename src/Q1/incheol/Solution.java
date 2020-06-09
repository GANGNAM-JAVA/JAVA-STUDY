package Q1.incheol;

import java.util.Arrays;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i =0;      //a
        for(i =0; i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }

    public static void main(String[] args) {
        String[] participants = {"incheol","steve","andrew"};
        String[] completions = {"incheol","steve","andrew2"};

        Solution solution = new Solution();
        String participantName = solution.solution(participants, completions);
        System.out.println("participantName = " + participantName);
    }
}

