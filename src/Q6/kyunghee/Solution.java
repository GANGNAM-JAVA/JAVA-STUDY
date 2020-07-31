class Solution {
    boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length + 1];

        for(int i = 0; i < words.length; i++) {
            // words에 target이 있는지 비교하고 있는 경우에만 변환
            if(target.equals(words[i]))
                return dfs(begin, target, words);
        }
        // 변환할 수 없는 경우에는 0을 return
        return 0;
    }
    // begin부터 target까지 최소 이동 횟수를 구한다.
    public int dfs(String begin, String target, String[] words) {
        int answer = 0;
        String deepBegin;
        // word를 순회한다.
        for(int i = 0; i < words.length; i++) {
            // 방문한 곳인지 아닌지 확인한다.
            if(visit[i]) continue;

            for(int j = 0; j < begin.length(); j++) {
                deepBegin = begin;
                deepBegin = (j > 0 ? begin.substring(0, j) : "") + words[i].charAt(j) + (j < begin.length()-1 ? begin.substring(j+1) : "");

                if(deepBegin.equals(target)) {
                    return 1;
                }
                if(deepBegin.equals(words[i])) {
                    visit[i] = true;
                    answer = 1;
                    answer += dfs(deepBegin, target, words);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String begin = "hit", target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

        Solution solution = new Solution();

        System.out.println(solution.solution(begin, target, words));
    }
}
