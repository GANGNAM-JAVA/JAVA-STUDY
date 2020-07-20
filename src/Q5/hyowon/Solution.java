package Q5.hyowon;

public class Solution {
    /*
     * 단어 하나하나 for문을 돌면서 현재 위치에 막대기가 몇 개 있는지만 살핍니다.
     * 시간복잡도 O(n)
     * 평균 수행시간 4ms (최저 0.75ms, 최대 5.54ms)
     * */
    public int solution(String arrangement) {
        int currentStick = 0; // 온전한막대기
        int brokenSticks = 0; // 잘린막대기

        for (int i = 0; i < arrangement.length(); i++) {
            char test = arrangement.charAt(i);
            if (test=='('){
                if (arrangement.charAt(i+1) == ')') { // 레이저. 현재 겹쳐져 있는 막대기 갯수만큼 잘린 막대기 갯수가 늘어납니다.
                    brokenSticks += currentStick;
                    ++i;
                } else { // 막대기가 새로 추가되므로 온전한막대기++, 잘린막대기++
                    ++currentStick;
                    ++brokenSticks;
                }
            } else { // 온전한 막대기 하나가 줄어듦
                --currentStick;
            }

        }
        int answer = brokenSticks;
        return answer;
    }
}
