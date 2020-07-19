package Q6.incheol;

/**
 * @author Incheol Jung
 */
public class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        for(int i=0; i< begin.length(); i++){
            answer = recursive(i, target, words);
        }
        return answer;
    }

    private int recursive(int index, String target, String[] words){
        if(words[index] == target) return 1;

        if(isChangable(words[index], target)){
            return recursive(index+1, target, words) + 1;
        }else
            return 0;
    }

    private boolean isChangable(String begin, String target){
        int matchCount = 0;

        char[] beginCharArr = begin.toCharArray();
        char[] targetCharArr = target.toCharArray();


        for(int i = 0; i < beginCharArr.length; i++){
            if(beginCharArr[i] == targetCharArr[i]) {
                matchCount++;
                if(matchCount > 1) return false;
            }
        }

        return matchCount == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}
