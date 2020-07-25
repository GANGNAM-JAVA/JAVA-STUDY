package Q7.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-07-25
 * @DESCRIPTION
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> result = new HashMap<>();
        for (String email : emails) {
            int whelkIndex = email.indexOf("@");
            String localName = email.substring(0, whelkIndex);
            String domainName = email.substring(whelkIndex);

            int plusIndex = localName.indexOf("+");
            boolean isPlusExist = plusIndex != -1;
            if (isPlusExist) {
                String plusSubEmail = localName.substring(0, plusIndex);
                String resultKey = plusSubEmail.replace(".", "") + domainName;
                result.put(resultKey, 0);
            } else {
                String resultKey = localName.replace(".", "") + domainName;
                result.put(resultKey, 0);
            }
        }
        return result.size();
    }
}
