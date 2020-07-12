package Q4.jonghun;

import java.util.*;

class Solution {

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        // 우선순위 큐(Priority Queue)는 들어간 순서에 상관없이 일정한 규칙에 따라 우선순위를 선정하고, 우선순위가 가장 높은 데이터가 가장 먼저 나오게 된다.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // 우선순위 높은게 먼저나와야된다!!

        // 우선순위 큐에 셋팅
        for(int i : priorities){
            pq.add(i);
        }

        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)pq.peek()){ // 현재위치와 우선순위 큐의 대기목 값이 맞는지 비교

                    if(i == location) { // 문서의 위
                        return answer;
                    }

                    pq.poll(); // 큐에서 꺼낸다.
                    answer++; // 순번 증

                }else{
                    continue;
                }
            }
        }
        return answer;
    }



    public static void main(String[] args) {

        System.out.println("## solution start ");

        int[] priorities = {2,1,3,2};
        int location = 2;
        int answer = solution(priorities, location);
        System.out.println("## solution anwer =>  " + answer);

    }
}