package Q7.kyunghee;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {

    public static int numUniqueEmails(String[] emails) {
        Set<String> cache = new HashSet<>();    // email address 담기

        for (String email : emails) {
            String[] name = email.split("@");   // local name을 @을 기준으로 자르기
            String[] address = name[0].split("\\+");    // '+'를 split.
            // System.out.println(email + " = " + name[0]);

            cache.add(address[0].replace(".", "") + "@" + name[1]);     // '.' 이면 공백으로 대체하고 '@' 에 domain name을 더하기

        }
        return cache.size();


    }
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        numUniqueEmails(emails);
    }
}