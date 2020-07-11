package Q3.hyowon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        // case 1
        int[] progresses1 = {93, 30, 55};
        int[] speeds1     = {1, 30, 5};
        solution(progresses1,speeds1);

        // case 2
        int[] progresses2 = {93, 30, 55, 1, 99};
        int[] speeds2     = {1,  30, 5,  1, 100};
        solution(progresses2,speeds2);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        // 평균 수행시간 1.7ms
        HashMap<Integer, Integer> workQuantity = new HashMap<>();
        int workingDay;
        int releaseDay = 0;
        int index = -1;

        // 시간복잡도 O(n)
        for (int i = 0; i < progresses.length; i++) {
            workingDay = calculateWorkingDay(i, progresses, speeds);

            // (작업진도가 1, 작업속도가 1인 경우) 최장 workingDay는 99일이니 이 기능 이후로는 모두 99일째에 배포된다.
            // 그러나 이 코드가 추가되었다고 해서 채점시 수행시간이 유의미하게 줄진 않는다.
            if (workingDay == 99) {
                workQuantity.put(++index, progresses.length - i);
                break;
            }

            if (workingDay > releaseDay) {
                releaseDay = workingDay;
                workQuantity.put(++index, 1);
            } else {
                workQuantity.put(index, workQuantity.get(index) + 1);
            }
        }

        // 시간복잡도 O(n)
        return IntegerMapToArray(workQuantity);
    }

    static int calculateWorkingDay(int idx, int[] progresses, int[] speeds) {
        double workingDay = (100 - progresses[idx]) / (double) speeds[idx];
        return (int) Math.ceil(workingDay);
    }

    static int[] IntegerMapToArray(HashMap<Integer, Integer> map) {
        int[] intArray = new int[map.size()];
        for (int i = 0; i < map.size(); i++) {
            intArray[i] = map.get(i);
        }
        return intArray;
    }

}