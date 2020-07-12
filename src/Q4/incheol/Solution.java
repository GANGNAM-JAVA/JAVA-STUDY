package Q4.incheol;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Incheol Jung
 */
public class Solution {
    public int solution(int[] priorities, int location) {
        Integer[] tempArr = new Integer[priorities.length];
        int answer = 1;

        for(int i = 0; i < priorities.length; i++){
            tempArr[i] = priorities[i];
        }

        Arrays.sort(tempArr, Comparator.reverseOrder());


        for(int i = 0; i < tempArr.length; i++){
            if(tempArr[i] > priorities[location]) {
                answer++;
            }else{
                if(tempArr[i] == priorities[location]){
                    if(i == location) break;
                    else answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int count = sol.solution(new int[] {1, 1, 9, 1, 1, 1}, 0);

        System.out.println(count);
    }
}
