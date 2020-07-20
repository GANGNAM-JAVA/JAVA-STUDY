package Q6.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-07-21
 * @DESCRIPTION
 */

public class Solution {
    boolean[] booleans;
    int searchCount = 0;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        booleans = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(target)) {
                answer = dfs(1, i, words, target, begin);
                break;
            }
        }
        return answer;
    }

    private int dfs(int count, int currentIndex, String[] words, String currentWord, String begin) {
        if (check(begin, currentWord)) {
            return 1;
        }

        booleans[currentIndex] = true;
        for (int i = 0; i < words.length; i++) {
            if (!booleans[i] && check(words[i], currentWord)) {

            }
        }
    }

    boolean check(String candidateWord, String currentWord) {
        return true;
    }
}
