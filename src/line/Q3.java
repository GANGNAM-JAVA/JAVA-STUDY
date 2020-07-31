package line;

/**
 * @author Incheol Jung
 */
public class Q3 {
    int answer = 0;

    public int solution(int n, int[] bankbook) {
        answer = bankbook.length;
        boolean[] visited = new boolean[bankbook.length];

        for(int i=0; i<bankbook.length; i++){
            visited[i] = true;
            recursive(bankbook,0, bankbook[i], n, 0, visited);
            visited[i] = false;
        }

        return answer;
    }

    private void recursive(int[] bankbook, int index, int income, int limitIncome, int sumCount, boolean[] visited){
        if(index >= bankbook.length) {
            if(sumCount != 0) {
                System.out.println("index " + index + " sumCount " + sumCount);
                int tempCount = answer-sumCount;
                answer = tempCount < answer ? tempCount : answer;
            }
            return;
        }

        if(visited[index] == false){
            int sumIncome = income + bankbook[index];
            if(sumIncome == limitIncome){
                sumCount++;
                income = 0;

            }
            else if(sumIncome < limitIncome){
                visited[index] = true;
                income = sumIncome;
            }
        }
        recursive(bankbook, index+1, income, limitIncome, sumCount, visited);
    }

    public static void main(String[] args) {
        System.out.println("Q3");
        Q3 sol = new Q3();
        int answer = sol.solution(10, new int[]{1, 2, 3, 3, 3, 8});
        System.out.println(answer);

    }
}
