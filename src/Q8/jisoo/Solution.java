package Q8.jisoo;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"})); // 30
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"})); // 27
    }
    public static int calPoints(String[] ops) {
        Stack<Integer> scores = new Stack<>();
        int sum = 0;
        for(int i=0 ; i<ops.length ; i++) {
            String element = ops[i];
            if(ops[i].equals("+")) {
                Integer last1 = scores.pop();
                Integer last2 = scores.pop();
                sum += last1 + last2;

                scores.push(last2);
                scores.push(last1);
                scores.push(last1 + last2);
            } else if(ops[i].equals("D")) {
                Integer last = scores.pop();
                sum += last * 2;
                scores.push(last);
                scores.push(last * 2);

            } else if(ops[i].equals("C")) {
                Integer last = scores.pop();
                sum -= last;
            } else {
                Integer num = Integer.parseInt(ops[i]);
                sum += num;
                scores.push(num);
            }

            System.out.println("sum : " + sum + ", peek :" + scores.peek());
        }

        return sum;
    }
}

