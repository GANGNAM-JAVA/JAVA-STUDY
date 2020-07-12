package Q4.incheol;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Incheol Jung
 */
public class Solution {
    public int solution(int[] priorities, int location) {
        Integer[] sortedPriorities = new Integer[priorities.length];
        int answer = 1;

        for(int i = 0; i < priorities.length; i++){
            sortedPriorities[i] = priorities[i];
        }

        Arrays.sort(sortedPriorities, Comparator.reverseOrder());

        for(int i = 0; i < sortedPriorities.length; i++){
            for(int j = 0; j < priorities.length; j++){
                if(sortedPriorities[i] == priorities[j]){
                    if(j == location) return answer;
                    answer++;
                    i++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int count = sol.solution(new int[] {2,2,2,1,3,4}, 3);

        System.out.println(count);
    }
}
