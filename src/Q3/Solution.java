package Q3;
/*
 * @USER JungHyun
 * @DATE 2020-06-28
 * @DESCRIPTION
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        if (progresses.length != speeds.length) {
            throw new IllegalArgumentException("argument error");
        }
        //모든 기능 갯수
        final int PROGRESSES_CNT = progresses.length;
        //기능 종료 상태
        final int FINISH = 100;
        //배포되는 기능 갯수 리스트
        List<Integer> progressesCntsByDeploy = new ArrayList<>();
        //기능 배열 중, 배포 우선순위가 가장 높은 기능의 위치
        int needDeployProgressindex = 0;

        //모든 기능이 배포될 때까지 반복 -> O(?)
        while (needDeployProgressindex < PROGRESSES_CNT) {
            //배포가 필요한 모든 기능들 작업 진행 -> O(n)
            for (int i = needDeployProgressindex; i < PROGRESSES_CNT; i++) {
                if (progresses[i] < FINISH) {
                    progresses[i] += speeds[i];
                }
            }
            //배포 대상 기능 추출 -> O(?)
            int deployProgressesCnt = 0;
            while (FINISH <= progresses[needDeployProgressindex]) {
                needDeployProgressindex++;
                deployProgressesCnt++;
                if (PROGRESSES_CNT <= needDeployProgressindex) {
                    break;
                }
            }
            //배포 대상 기능이 추출되었을 경우
            //배포되는 기능 갯수 리스트에 배포 대상 기능 갯수 추가
            if (deployProgressesCnt != 0) {
                progressesCntsByDeploy.add(deployProgressesCnt);
            }
        }

        return progressesCntsByDeploy.stream().mapToInt(i -> i).toArray();
    }
}