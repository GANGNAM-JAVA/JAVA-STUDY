import java.util.Stack;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> hashMap = new HashMap<>();
		hashMap.put('(', ')');
		hashMap.put('{', '}');
		hashMap.put('[', ']');

		for (char ch : s.toCharArray()) {
			switch (ch) {
				case '(':
				case '{':
				case '[':
					stack.push(ch);
					break;
				case ')':
				case '}':
				case ']':
					if (stack.isEmpty())
						return false;

					char top = stack.peek();
					if (hashMap.get(top) == ch)
						stack.pop();
					else
						return false;
					break;
			}
		}
		return stack.isEmpty();
    }
}
