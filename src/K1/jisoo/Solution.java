package K1.jisoo;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public static  String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        // 다이얼 초기화
        int [][] dial = {
                {1,2,3}, {4,5,6}, {7,8,9}, {-1,0,-2}
        };

        Map<Integer, AbstractMap.Entry<Integer, Integer>> location = new HashMap<>();
        for(int i=0 ; i<dial.length ; i++) {
            for(int j=0 ; j<dial[i].length ; j++) {
                location.put(dial[i][j], new AbstractMap.SimpleEntry<>(i, j)); // 각 번호당 좌표를 초기화.
            }
        }

        int leftNum = -1, rightNum = -2; // 왼쪽 손, 오른쪽의 시작 번호. 각 루프에서 마지막 저장 번호. (*, # 문자를 각가 숫자로 임시 치환)
        for(int i=0 ; i<numbers.length ; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                leftNum = numbers[i];
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                rightNum = numbers[i];
            } else {
                // 2, 5, 8, 0
                Map.Entry<Integer, Integer> loc = location.get(numbers[i]); // 현재 번호의 좌표
                Map.Entry<Integer, Integer> leftLoc = location.get(leftNum); // 왼쪽 손가락의 마지막 번호의 좌표
                Map.Entry<Integer, Integer> rightLoc = location.get(rightNum); // 오른쪽 손가락의 마지막 번호의 좌표

                int leftDiff = Math.abs(leftLoc.getKey() - loc.getKey()) + Math.abs(leftLoc.getValue() - loc.getValue());
                int rightDiff = Math.abs(rightLoc.getKey() - loc.getKey()) + Math.abs(rightLoc.getValue() - loc.getValue());

                // 절댓값이 같으면 hand로 설정
                if(leftDiff == rightDiff) {
                    if(hand.equals("left")) {
                        answer.append("L");
                        leftNum = numbers[i];
                    } else {
                        answer.append("R");
                        rightNum = numbers[i];
                    }
                } else if(leftDiff < rightDiff){
                    answer.append("L");
                    leftNum = numbers[i];
                } else {
                    answer.append("R");
                    rightNum = numbers[i];
                }

            }

        }
        return answer.toString();
    }
}
