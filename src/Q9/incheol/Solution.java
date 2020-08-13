package Q9.incheol;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Incheol Jung
 */
public class Solution {
    enum Bucket {
        OPEN_CURLYBRACET('('),
        CLOSE_CURLYBRACET(')'),
        OPEN_BRACKET('{'),
        CLOSE_BRACKET('}'),
        OPEN_SQAURE('['),
        CLOSE_SQAURE(']');

        private Character val;

        Bucket(Character val) {
            this.val = val;
        }

        public Character getValue(){
            return val;
        }

        public static Bucket getByValue(Character value) {
            return Arrays.stream(values()).filter(it -> it.getValue().equals(value)).findFirst().get();
        }
    }

    public boolean isValid(String s) {
        boolean result = true;
        char[] bucketArray = s.toCharArray();
        Stack<Bucket> bucketStack = new Stack<>();

        for(int i =0; i < bucketArray.length && result; i++){
            Bucket currentBucket = Bucket.getByValue(bucketArray[i]);

            switch (currentBucket){
                case OPEN_BRACKET:
                case OPEN_SQAURE:
                case OPEN_CURLYBRACET:
                    bucketStack.push(currentBucket);
                    break;
                case CLOSE_BRACKET:
                    if(bucketStack.isEmpty() || bucketStack.pop() != Bucket.OPEN_BRACKET) result = false;
                    break;
                case CLOSE_SQAURE:
                    if(bucketStack.isEmpty() || bucketStack.pop() != Bucket.OPEN_SQAURE) result = false;
                    break;
                case CLOSE_CURLYBRACET:
                    if(bucketStack.isEmpty() || bucketStack.pop() != Bucket.OPEN_CURLYBRACET) result = false;
                    break;
            }
        }

        return bucketStack.isEmpty() ? result : false;
    }

    public static void main(String[] args) {
        System.out.println("incheol");
        Solution sol = new Solution();

        boolean result = sol.isValid("]");
        System.out.println(result);
    }
}
