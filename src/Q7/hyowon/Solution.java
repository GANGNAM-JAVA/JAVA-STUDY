package Q7.hyowon;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    // https://leetcode.com/problems/unique-email-addresses/
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] test = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(s.numUniqueEmails(test));

        System.out.println(s.numUniqueEmailsTwo(test));
    }

    /**
    * 첫번째 풀이 : 정규표현식 사용
    * @를 기준으로 자르고
    * localName  : '.'을 공백문자로, '+'로 시작해 @전까지의 문자열을 공백문자로 치환
    * domainName : 작업없음
    * 이후 HashMap에 key로 (localName + "@" + domainName) 을 put합니다.
     *
     * Runtime: 51 ms, faster than 12.08% of Java online submissions for Unique Email Addresses.
     * Memory Usage: 41.2 MB, less than 12.06% of Java online submissions for Unique Email Addresses.
    * */
    public int numUniqueEmails(String[] emails) {
        HashSet<String> distinctEmail = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            String[] emailArray = emails[i].split("@");
            emails[i] = emailArray[0].replaceAll("\\.", "").replaceAll("\\+\\S+","")+"@"+emailArray[1];
            distinctEmail.add(emails[i]);
        }

        return distinctEmail.size();
    }

    /**
     * 두번째 풀이 : StringBuilder 사용
     * @를 기준으로 자르고
     * localName  : char 배열을 돌며 '.'이 아니면 append, '+'이면 배열 종료
     * domainName : 작업없음
     * 이후 HashSet에 (localName + "@" + domainName)을 add합니다.
     *
     * Runtime: 20 ms, faster than 54.36% of Java online submissions for Unique Email Addresses.
     * Memory Usage: 46.9 MB, less than 5.01% of Java online submissions for Unique Email Addresses.
     * */
    public int numUniqueEmailsTwo(String[] emails) {
        HashSet<String> distinctEmail = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            String[] emailArray = emails[i].split("@");
            distinctEmail.add(getRealLocalName(emailArray[0]) + "@" + emailArray[1]);
        }

        return distinctEmail.size();
    }
    private String getRealLocalName(String localName) {
        char[] localNameChar = localName.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : localNameChar) {
            if (ch == '+') return sb.toString();
            if (ch != '.') sb.append(ch);
        }

        return sb.toString();
    }

}
