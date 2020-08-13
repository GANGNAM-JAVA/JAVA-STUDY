class Solution {
     public boolean isValid(String s) {
         Stack<Character> stack = new Stack<Character>();

         for(char c : s.toCharArray()) {
             if (isOpenSymbol(c)) {
                 stack.push(c);
             } else if (!stack.isEmpty() && isCloseSymbolAndCounterpart (c, stack, stack.peek())) {
                 stack.pop();
             } else {
                 return false;
             }
         }
         return stack.isEmpty();
     }

     private boolean isOpenSymbol(char c) {
        return c == '(' || c == '['  || c == '{';
     }

     private boolean isCloseSymbolAndCounterpart(char c, Stack<Character> stack, char peek) {
           if (peek == '(' && c == ')') {
                return true;
           } else if (peek == '[' && c == ']') {
                return true;
           } else if (peek == '{' && c == '}') {
                return true;
           }
           return false;
     }
 }