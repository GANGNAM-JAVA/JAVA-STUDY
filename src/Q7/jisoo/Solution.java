package Q7.jisoo;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(numUniqueEmails(new String[]{"test.e+mail+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","test.email.test+david@lee.tcode.com"}));

    }
    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            // @ 기준으로 문자를 나눔.
            int index1 = email.indexOf('@');
            String localName = email.substring(0, index1);
            String domainName = email.substring(index1);

            // . 문자 제거
            localName = localName.replaceAll("\\.", ""); // '.' 제거

            // + 뒤의 문자는 제외.
            int index2 = localName.indexOf('+'); // '+'가 2개 이상이더라고 맨 앞에 인덱스만 찾고 지우면 됨.
            if(index2 != -1) {
                localName = localName.substring(0, index2);
            }

            String result = localName + '@' + domainName;
            System.out.println(result);
            uniqueEmails.add(result);
        }

        return uniqueEmails.size();
    }
}
