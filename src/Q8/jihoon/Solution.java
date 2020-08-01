import java.util.Stack;

class Solution {
    public int calPoints(String[] ops) {
		int points = 0;
		Stack<Integer> st = new Stack<>();
		st.push(points);

		for (String op : ops) {
			if (op.equals("+")) {
				int last = st.pop();
				int lastBefore = st.peek();
				st.push(last);
				
				int insert = last + lastBefore;
				points += insert;
				st.push(insert);
			} 
			else if (op.equals("C")) {
				int last = st.pop();
				points -= last;
			} 
			else if (op.equals("D")) {
				int insert = st.peek() * 2;
				points += insert;
				st.push(insert);
			} 
			else {
				int insert = Integer.parseInt(op);
				points += insert;
				st.push(insert);
			}
		}
		return points;
    }
}
