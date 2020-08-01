package practice.Q2.incheol;


/**
 * @author Incheol Jung
 */
public class Solution {

    public int[] dailyTemperaturesOrigin(int[] T) {
        int[] results = new int[T.length];

        for(int i =0; i <T.length; i++){
            for(int j = i; j <T.length; j++){
                if(T[i] < T[j]) {
                    results[i] = j-i;
                    break;
                }
            }
        }
        return results;
    }

    public int[] dailyTemperatures(int[] T) {
        int[] results = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            int count = (recursiveCount(T[i], i + 1, T) - i);
            results[i] = count < 0 ? 0 : count;
        }
        return results;
    }

    private int recursiveCount(int begin, int index, int[] T){
        if(index >= T.length) return 0;

        if(begin > T[index]) {
            return recursiveCount(begin, index + 1, T);
        }else
            return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        Solution sol = new Solution();

        int[] results = sol.dailyTemperatures(arr);

        for(int result : results){
            System.out.println(result);
        }
    }
}

