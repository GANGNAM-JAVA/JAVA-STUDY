package Q8.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-07-31
 * @DESCRIPTION
 */

import java.util.Stack;

public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> opsStack = new Stack<>();
        for (String op : ops) {
            if ("+".equals(op)) {
                Integer prevScore = opsStack.pop();
                Integer prevprevScore = opsStack.peek();
                opsStack.push(prevScore);
                opsStack.push(prevprevScore + prevScore);
            } else if ("C".equals(op)) {
                opsStack.pop();
            } else if ("D".equals(op)) {
                opsStack.push(opsStack.peek() * 2);
            } else {
                opsStack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (Integer score : opsStack) {
            sum += score;
        }
        return sum;
    }
}
