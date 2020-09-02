package Q11.kyunghee;

class Solution {

    public String solution(int[] numbers, String hand) {
        String answer = "";
        String left = "*";
        String right = "#";

        for(int number : numbers) {
            if(number == 1 || number == 4 || number == 7) {     // Left hand
                left = String.valueOf(number);
                answer += "L";
            } else if(number == 3 || number == 6 || number == 9) {    // Right hand
                right = String.valueOf(number);
                answer += "R";
            } else {                                                  // 2, 5, 8, 0 거리순
                int[] index = getDirectionIndex(String.valueOf(number));
                int[] leftHand = getDirectionIndex(left);
                int[] rightHand = getDirectionIndex(right);

                int leftDirection = Math.abs(index[0]-leftHand[0])+ Math.abs(index[1]-leftHand[1]);
                int rightDirection = Math.abs(index[0]-rightHand[0])+ Math.abs(index[1]-rightHand[1]);

                if(leftDirection < rightDirection) {
                    left = String.valueOf(number);
                    answer += "L";
                } else if(leftDirection > rightDirection) {
                    right = String.valueOf(number);
                    answer += "R";
                } else {
                    if(hand.equals("left")) {
                        left = String.valueOf(number);
                        answer += "L";
                    } else{
                        right = String.valueOf(number);
                        answer += "R";
                    }
                }
            }
        }
        return answer;
    }

    private int[] getDirectionIndex(String num) {
        String[][] keypad = new String[][] {
                {"1","2","3"},
                {"4","5","6"},
                {"7","8","9"},
                {"*","0","#"}
        };
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(String.valueOf(num).equals(keypad[i][j]))
                    return new int[]{i, j};
            }
        }
        return null;
    }
}
