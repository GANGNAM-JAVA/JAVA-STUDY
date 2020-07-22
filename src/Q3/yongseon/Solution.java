package Q3.yongseon;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> workDayList = new ArrayList<Integer>();
		calculateWorkDay(workDayList, progresses, speeds);

		return this.getDeployDayCount(workDayList);
	}

	// �ش� ������ �������� 
	private int[] getDeployDayCount(List<Integer> workDayList) {
		List<Integer> answer = new ArrayList<Integer>();
		for (int index = 0; index < workDayList.size(); index++) {
			int deployDayCount = 1;
			int saveIndex = index;
			
			for (int subIndex = index + 1; subIndex < workDayList.size(); subIndex++) {
				// �۾��� ����� ���� �۾��� �Ϸ� ���°� �ƴϸ� ���� �Ұ�
				// ���� �۾��� ���� �۾����� ũ�� ������츸 �ѹ��� �����Ϸ� ���� ó�� 
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

	// �۾��ҿ��� ���
	private List<Integer> calculateWorkDay(List<Integer> workDayList, int[] progresses, int[] speeds) {
		for (int index = 0; index < progresses.length; index++) {
			int endDay = (100 - progresses[index]) % speeds[index] == 0 ? (100 - progresses[index]) / speeds[index]
					: (100 - progresses[index]) / speeds[index] + 1;

			workDayList.add(endDay);
		}
		return workDayList;
	}
}