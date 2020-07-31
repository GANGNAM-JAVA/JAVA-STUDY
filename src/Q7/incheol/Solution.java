package Q7.incheol;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author Incheol Jung
 */
public class Solution {
    // Set의 size를 반환 하였습니다.
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = Arrays.stream(emails).map(i -> convertEmailWithArray(i)).collect(toSet());
        return emailSet.size();
    }

    // sol 1. 정규식을 이용한 이메일 문자열 변환
    private String convertEmailWithRegex(String email){
        // @를 기준으로 첫번째 단어만 변환하는 작업이라 구분하였습니다.
        String[] arr = email.split("\\@");
        // '.'을 제거하도록 하였습니다.
        arr[0] = arr[0].replaceAll("\\.","");
        // '+'뒤에 단어를 제거하도록 하였습니다.
        arr[0] = arr[0].replaceAll("(\\+)\\w*","");

        return arr[0] + "@" + arr[1];
    }

    // sol 2. 문장을 문자열 배열로 치환하여 단어별로 조건에 따라 append를 수행한다.
    private String convertEmailWithArray(String email){
        StringBuffer convertedEmail = new StringBuffer();
        char[] emailArray = email.toCharArray();
        boolean isSuffix = false;
        boolean appendable = true;

        for(char ch : emailArray){
            // @ 이후는 무조건 그대로 append 한다.
            if(isSuffix){
                convertedEmail.append(ch);
            }else{
                if(ch == '+'){ appendable = false; } // +가 붙으면 그 이후엔 append를 하지 않는다. @ 나오기 전까지는..
                else if(ch == '@'){ convertedEmail.append(ch); isSuffix = true; } // @가 나온 이후에는 isSuffix를 true로 하여 무조건 append 한다.
                else if(ch != '.' && appendable){ convertedEmail.append(ch); } // +, @ 가 아니고 '.'가 아니면서 @ 이후가 아닌 appendable이 true이면 append 한다.
            }
        }
        System.out.println(convertedEmail);
        return String.valueOf(convertedEmail);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(sol.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"}));
    }
}
