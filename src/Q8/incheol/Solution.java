package Q8.incheol;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Incheol Jung
 */
public class Solution {
    public enum Operator {
        PLUS("+"),
        REMOVE("C"),
        DOUBLE("D");

        private String operator;

        Operator(String operator) {
            this.operator = operator;
        }

        public String getValue(){
            return operator;
        }

        public static Operator getByValue(String value) {
            return Arrays.stream(values()).filter(it -> it.getValue().equals(value)).findFirst().get();
        }
    }

    // Sol1. enum을 사용한 풀이 / 평균 속도 : 45 ms
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> scores = new Stack<>();
        Integer temp_score_first;
        Integer temp_score_second;

        for(String op : ops){
            if(!op.matches("-?\\d+(\\.\\d+)?")){
                switch (Operator.getByValue(op)) {
                    case REMOVE :
                        sum -= scores.pop();
                        break;
                    case DOUBLE :
                        sum += (scores.peek()*2);
                        scores.push((scores.peek()*2));
                        break;
                    case PLUS :
                        temp_score_first = scores.pop();
                        temp_score_second = scores.pop();

                        scores.push(temp_score_second);
                        scores.push(temp_score_first);
                        scores.push(temp_score_first + temp_score_second);

                        sum += temp_score_first + temp_score_second;
                        break;
                    default: break;
                }
            } else {
                sum += Integer.parseInt(op);
                scores.push(Integer.parseInt(op));
            }

        }

        return sum;
    }

    // sol2. if,else를 사용한 풀이 / 평균 속도 : 2 ms
//    public int calPoints(String[] ops) {
//        int sum = 0;
//        Stack<Integer> scores = new Stack<>();
//        Integer temp = 0;
//        Integer temp2 = 0;
//        for(String op : ops){
//            if(op.equals("C")){
//                sum -= scores.pop();
//            } else if(op.equals("D")){
//                temp = (scores.peek()* 2);
//                sum += temp;
//                scores.push(temp);
//            } else if(op.equals("+")){
//                temp = scores.pop();
//                temp2 = scores.pop();
//
//                scores.push(temp2);
//                scores.push(temp);
//                scores.push(temp + temp2);
//
//                sum += temp + temp2;
//            } else{
//                sum += Integer.parseInt(op);
//                scores.push(Integer.parseInt(op));
//            }
//        }
//
//        return sum;
//    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int sum = sol.calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
        System.out.println("sum = " + sum);
    }
}
