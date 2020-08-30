package K1.jihoon;

class Solution {

    public String solution(int[] numbers, String hand) {
        String answer = "";

        int leftR = 3, leftC = 0;
        int rightR = 3, rightC = 2;

        for (int number : numbers) {
            if (number == 0) number = 11;
            number--;

            int r = number / 3, c = number % 3;

            boolean isLeft = true;
            if (c == 0)
                isLeft = true;
            else if (c == 2)
                isLeft = false;
            else {
                int leftDiff = Math.abs(leftR - r) + Math.abs(leftC - c);
                int rightDiff = Math.abs(rightR - r) + Math.abs(rightC - c);

                if (leftDiff < rightDiff)
                    isLeft = true;
                else if (leftDiff > rightDiff)
                    isLeft = false;
                else {
                    if (hand.equals("left"))
                        isLeft = true;
                    else
                        isLeft = false;
                }
            }

            if (isLeft) {
                leftR = r;
                leftC = c;
                answer += "L";
            }
            else {
                rightR = r;
                rightC = c;
                answer += "R";
            }
        }
        return answer;
    }
}

