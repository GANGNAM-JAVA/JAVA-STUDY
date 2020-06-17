package Q1.hyowon;

import java.util.*;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        quickSort(participant, 0, participant.length - 1);
        quickSort(completion, 0, completion.length - 1);

        String answer = participant[participant.length - 1];

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
    void quickSort(String[] arr, int leftIdx, int rightIdx) {
        int i = leftIdx;
        int j = rightIdx;
        String pivot = arr[leftIdx + (rightIdx - leftIdx) / 2];

        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0) {
                i++;
            }

            while (arr[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(arr, i, j);
                i++; j--;
            }
        }

        if (leftIdx < j) {
            quickSort(arr, leftIdx, j);
        }
        if (i < rightIdx) {
            quickSort(arr, i, rightIdx);
        }

    }

    void exchangeNames(String[] arr, int i, int j) {
        String temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
