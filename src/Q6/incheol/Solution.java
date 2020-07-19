package Q6.incheol;

/**
 * @author Incheol Jung
 */
public class Solution {
    // 최단 단계를 클래스 전역 변수로 관리한다.
    int answer = 0;

    // 재귀 함수로 실행한다.
    public int solution(String begin, String target, String[] words) {
        recursive(begin, target,0, words, 0, new boolean[words.length]);
        return answer;
    }

    /**
     *
     * @param begin 시작할 단어(인덱스가 변경할때마다 begin 단어가 변경됨)
     * @param target 결과적으로 매칭해야 할 단어(변하지 않아야 함)
     * @param index words의 index를 조율하기 위한 변수
     * @param words words
     * @param count 단계가 증가할 때마다 카운트를 증가 시킴
     * @param visited "hit", "hhh" , new String[]{"hhh","hht"} 케이스 일 경우 처음부터 다시 돌아가서 조회할 경우 필요한 방문 표
     */
    void recursive(String begin, String target, int index,  String[] words, int count, boolean[] visited){
        // begin을 이동하여 target과 일치할 경우 answer 값에 count를 넣어주는데 최솟값일 경우에만 answer 값을 변경해준다.
        if(begin.equals(target)) {
            answer = answer == 0 ? count : answer > count ? count : answer;
        }
        // 무한루프가 빠지지 않도록 index 값이 words 사이즈라면 재귀를 멈춘다.
        if(index == words.length) return;

        for(int i=index; i < words.length; i++) {
            if(isChangable(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                recursive(words[i], target, 0, words, count+1, visited);
                visited[i] = false;
            } else{
                recursive(begin, target, i + 1, words, count, visited);
            }
        }
    }

    // 두 단어를 비교하여 한 단어만 다른지 확인하여 true, false 값을 내어준다.
    private boolean isChangable(String begin, String target){
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
            "hhh",
            new String[]{"hhh","hht"}
//            new String[]{"hot"}
//            new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
        ));
    }
}
