package Q4.kyunghee;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

	public int solution(int[] priorities, int location) {

        // 배열에 담긴 인쇄 대기목록의 우선 순위
		// 배열을 연결리스트로 변경
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			list.add(priorities[i]);
		}

		// 원본 배열 우선 순위 비교 오름차순 정렬
		Arrays.sort(priorities);

		int index = 0; // 현재 가장 앞에 있는 숫자의 인덱스
		int answer = 0; // 목표 문서 출력 횟수
        int max = priorities.length-1; // 가장 큰 마지막 오름차순한 수

		while (list.size() > 0) {
			if (index == list.size()) {
				index = 0;
			}
			// 배열의 가장 마지막 값과 같으면 출력
			if (list.get(index) == priorities[max - answer]) {
				answer++;

				if (index == location) {
					break;
				} else if (index < location) {
					location--;
				}
				list.remove(index);

			} else {
				if (index == list.size() - 1) {
					index = 0;
				} else {
					index++;
				}
			}
		}
		return answer;
	}
}