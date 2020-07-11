package Q3.incheol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Incheol Jung
 */
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] countsOfWorkDay = new int[progresses.length];
        for(int i=0; i <progresses.length; i++){
            countsOfWorkDay[i] = calculateWorkDays(progresses[i], speeds[i]);
        }

        return calculateDeployCountDays(countsOfWorkDay).stream().mapToInt(i->i).toArray();
    }

    private List<Integer> calculateDeployCountDays(int[] countsOfWorkDay){
        List<Integer> deployCountDays = new ArrayList<>();
        int currentMaxWorkCount = 0;
        int index = -1;

        for(Integer workCount : countsOfWorkDay){
            if(currentMaxWorkCount >= workCount){
                deployCountDays.set(index, deployCountDays.get(index)+1);
            }else {
                currentMaxWorkCount = workCount;
                deployCountDays.add(1);
                index++;
            }
        }

        return deployCountDays;
    }

    private int calculateWorkDays(int remainWork, int dayOfWork){
        return (100 - remainWork) / dayOfWork;
    }

    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        Solution sol = new Solution();

        int[] results = sol.solution(progresses, speeds);
        Arrays.stream(results).forEach(i -> System.out.println(i));
    }
}

