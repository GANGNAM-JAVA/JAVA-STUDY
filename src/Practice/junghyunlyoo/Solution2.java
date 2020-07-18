package Practice.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-07-18
 * @DESCRIPTION
 */

public class Solution2 {
    public int[] dailyTemperatures(int[] T) {
        calculateDays(T, 0, 1);
        return T;
    }

    public void calculateDays(int[] T, int currentIndex, int nextIndex) {
        if (T.length <= currentIndex) {
            return;
        }
        if (T.length <= nextIndex) {
            T[currentIndex] = 0;
            calculateDays(T, currentIndex + 1, currentIndex + 2);
        } else if (T[currentIndex] < T[nextIndex]) {
            T[currentIndex] = nextIndex - currentIndex;
            calculateDays(T, currentIndex + 1, currentIndex + 2);
        } else {
            calculateDays(T, currentIndex, nextIndex + 1);
        }
    }
}
