package Q6.incheol;

/**
 * @author Incheol Jung
 */
public class Solution {
    int answer;

    public int solution(String begin, String target, String[] words) {
        recursive(begin, target, 0, words, 0);
        return answer;
    }

    private void recursive(String begin, String target, int index, String[] words, int count){
        if(begin.equals(target)) {
            answer = answer > count ? count : answer;
            return;
        }

        if(index == words.length-1) return;

        for(int i=0; i <words.length; i++){
            if(isChangeable(begin, words[index])){
                recursive(begin, target, index + 1, words, count++);
            }else {
                recursive(words[index], target, index + 1, words, count);
            }
        }
    }

    private boolean isChangeable(String begin, String target){
        int unMatchCount = 0;

        char[] beginCharArr = begin.toCharArray();
        char[] targetCharArr = target.toCharArray();

        for(int i = 0; i < beginCharArr.length; i++){
            if(beginCharArr[i] != targetCharArr[i]) {
                unMatchCount++;
                if(unMatchCount > 1) return false;
            }
        }
        return unMatchCount == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
            "hit",
            "cog",
            new String[]{"hot", "dot", "dog", "lot", "log", "cog"})
        );
    }


//    public int solution(String begin, String target, String[] words) {
//        int answer = 0;
//        return recursiveSearch(begin, target, words, answer);
//    }
//
//    private int recursiveSearch(String begin, String target, String[] words, int answer){
//        for(String word : words){
//            if(begin.equals(target)){
//                return answer;
//            }else {
//                if(word == words[words.length-1]) return 0;
//
//                if(compareChar(begin,word)){
//                    answer++;
//                    return recursiveSearch(word, target, words, answer);
//                }
//            }
//        }
//        return 0;
//    }
//
//    private boolean compareChar(String searchedString, String targetString){
//        int cnt = 0;
//        for (int i = 0; i < searchedString.length(); i++) {
//            for (int j = 0; j < targetString.length(); j++) {
//                if (searchedString.charAt(i) == targetString.charAt(j)) {
//                    cnt++; // ont for character equal
//                    if(cnt >= 2) return false;
//                }
//            }
//        }
//        return cnt == 1;
//    }
}
