import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> workDayList = new ArrayList<Integer>();
		calculateWorkDay(workDayList, progresses, speeds);

		return this.getDeployDayCount(workDayList);
	}

	// 해당 배포일 배포개수 
	private int[] getDeployDayCount(List<Integer> workDayList) {
		List<Integer> answer = new ArrayList<Integer>();
		for (int index = 0; index < workDayList.size(); index++) {
			int deployDayCount = 1;
			int saveIndex = index;
			
			for (int subIndex = index + 1; subIndex < workDayList.size(); subIndex++) {
				// 작업이 끝났어도 이전 작업이 완료 상태가 아니면 배포 불가
				// 다음 작업이 현재 작업보다 크지 않은경우만 한번의 배포일로 묶어 처리 
				if (workDayList.get(index) < workDayList.get(subIndex)) {
					break;
				} else {
					saveIndex++;
					deployDayCount++;
				}
			}
			answer.add(deployDayCount);
			index = saveIndex;
		}
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	// 작업소요일 계산
	private List<Integer> calculateWorkDay(List<Integer> workDayList, int[] progresses, int[] speeds) {
		for (int index = 0; index < progresses.length; index++) {
			int endDay = (100 - progresses[index]) % speeds[index] == 0 ? (100 - progresses[index]) / speeds[index]
					: (100 - progresses[index]) / speeds[index] + 1;

			workDayList.add(endDay);
		}
		return workDayList;
	}
}