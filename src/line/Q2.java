package line;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Incheol Jung
 */
public class Q2 {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if ("".equals(input)) {
            System.out.println("ERROR");
            return;
        }

        String[] inputArray = input.split(" ");
        int sum = 0;
        int errorCount = 0;
        int successCount = 0;

        for (int i = 0; i < inputArray.length; i++) {
            int currentIndexDegree = Integer.parseInt(inputArray[i]);
            //현재 온도가 -200 미만이거나 200 초과일 경우 ERROR
            if (!checkInvalidTemperature(currentIndexDegree)) {
                errorCount++;
                continue;
            }

            //현재 온도 이전 2개의 온도와
            //현재 온도 이후 2개의 온도 모두가 3도 이상 차이 날 경우 ERROR
            if (!isExistProperTemperature(i, inputArray)) {
                errorCount++;
                continue;
            }

            sum += currentIndexDegree;
            successCount++;
        }

        printResult(successCount, sum, errorCount, inputArray);
    }

    private static void printResult(int successCount, int sum, int errorCount, String[] inputArray){
        if (successCount == 0) {
            System.out.println("ERROR");
        } else {
            int average = sum / (inputArray.length - errorCount);
            System.out.println(average);
        }
    }

    private static boolean checkInvalidTemperature(Integer currentIndexDegree){
        return -200 <= currentIndexDegree && currentIndexDegree <= 200;
    }

    private static boolean isExistProperTemperature(int currentIndex, String[] inputArray) {
        int startIndex = currentIndex < 2 ? 0 : currentIndex - 2;
        int endIndex = inputArray.length - 3 < currentIndex ? inputArray.length - 1 : currentIndex + 2;

        int currentDegree = Integer.parseInt(inputArray[currentIndex]);
        if (startIndex == endIndex && endIndex == currentIndex) {
            return true;
        }

        while (startIndex <= endIndex) {
            int currentNum = Integer.parseInt(inputArray[startIndex]);
            //현재 인덱스일 경우는 체크하지 않음
            //반복중인 온도들 중 하나라도 현재 온도와 차이가 3 미만으로 날 경우 -> 반복 종료
            if (startIndex != currentIndex && Math.abs(currentDegree - currentNum) < 3) {
                break;
            }
            startIndex++;
        }
        return startIndex <= endIndex;
    }
}
