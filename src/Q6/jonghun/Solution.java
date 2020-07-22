package Q6.jonghun;

public class Solution {

    static int answer = 999999; // 최소값을 구하기위한 임시 큰 값

    static public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length]; // words 의 방문을 체크하는 배열
        int count = 0;
        dfs(begin, target, words, visited, count);

        if(answer == 999999) // 없으면 0
            return 0;

        return answer;
    }

    static void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
        if (begin.equals(target)) { // 값 찾았나 확인
            answer = answer >= count ? count : answer;  // 최소값 확인후 종료
            return ;
        }

        for (int i = 0; i < words.length; i++) {

            int diff = 0;

            if (visited[i] == true) continue; // 방문했던 곳 스

            for (int j = 0; diff <= 1 && j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j))
                    diff++; // 문자열 차이
            }

            if (diff == 1) {
                // dfs 호출전 방문표시
                visited[i] = true;
                count++;

                // dfs 호출
                dfs(words[i], target, words, visited, count);

                // 다음 dfs를 위해 원상복
                count--;
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("## solution start ");
        int answer = solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println("## solution anwer =>  " + answer);
    }
}
