package K1.junghyunlyoo;

class Solution {

    private class NumberSet {
        private final int[] numberArray;

        public NumberSet(int[] numberArray) {
            this.numberArray = numberArray;
        }

        public boolean hasNumber(int number) {
            for (int i : numberArray) {
                if (i == number) {
                    return true;
                }
            }
            return false;
        }

    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // 왼손, 오른손의 시작 지점 지정
        int leftHandPosition = 10; //*
        int rightHandPosition = 12; //#

        // 왼손, 오른손으로 클릭해야 하는 숫자 set 생성
        NumberSet leftNumberSet = new NumberSet(new int[]{1, 4, 7});
        NumberSet rightNumberSet = new NumberSet(new int[]{3, 6, 9});

        for (int number : numbers) {
            if (leftNumberSet.hasNumber(number)) {
                // 현재 반복중인 숫자를 왼손으로 클릭해야 하는 경우
                answer.append("L");
                leftHandPosition = number;
            } else if (rightNumberSet.hasNumber(number)) {
                // 현재 반복중인 숫자를 오른손으로 클릭해야 하는 경우
                answer.append("R");
                rightHandPosition = number;
            } else {
                // 현재 반복중인 숫자를 왼손과 오른손 모두 클릭할 수 있는 경우

                // 현재 반복중인 숫자가 0일 경우 11로 위치 지정
                if (number == 0) {
                    number = 11;
                }

                // 현재 반복중인 숫자와 왼손, 오른손과의 거리 계산
                int distanceLeftHandPotitionToNumber = getDistance(leftHandPosition, number);
                int distanceRightHandPotitionToNumber = getDistance(rightHandPosition, number);

                // 현재 반복중인 숫자와의 거리를 비교해서 왼손으로 클릭할지 오른손으로 클릭할지 구분
                if (distanceLeftHandPotitionToNumber < distanceRightHandPotitionToNumber) {
                    answer.append("L");
                    leftHandPosition = number;
                } else if (distanceLeftHandPotitionToNumber == distanceRightHandPotitionToNumber) {
                    if ("left".equals(hand)) {
                        answer.append("L");
                        leftHandPosition = number;
                    } else {
                        answer.append("R");
                        rightHandPosition = number;
                    }
                } else {
                    answer.append("R");
                    rightHandPosition = number;
                }
            }
        }
        return answer.toString();
    }

    public int getDistance(int currentNumber, int goalNumber) {
        // 현재 숫자와 목표 숫자가 3이상 차이가 날 경우,
        // 목표 숫자를 현재 숫자와 같은 라인으로 맞춰주기 위한 상수 생성
        final int helperNumber = currentNumber < goalNumber ? -3 : 3;
        // 현재 숫자와 목표 숫자와의 절댓값 저장
        int absBetweenCurrentNumberAndGoalNumber = 0;
        // 목표 숫자가 이동한 횟수 저장
        int moveCountToOtherLine = 0;
        while (true) {
            absBetweenCurrentNumberAndGoalNumber = Math.abs(currentNumber - goalNumber);
            // 목표 숫자와 현재 숫자가 같은 라인에 위치할 경우 계산 종료
            if (absBetweenCurrentNumberAndGoalNumber < 3) {
                break;
            }
            // 목표 숫자가 다른 라인으로 이동한 횟수
            moveCountToOtherLine += 1;
            // 목표 숫자 재조정
            goalNumber += helperNumber;
        }
        // 현재 숫자와 목표 숫자의 거리(가로) + 이동한 라인 횟수(세로)
        return absBetweenCurrentNumberAndGoalNumber + moveCountToOtherLine;
    }
}
