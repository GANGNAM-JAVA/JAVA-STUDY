package K3.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-09-06
 * @DESCRIPTION
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    private String removeSideMustache(String s) {
        return s.substring(0, s.length() - 2).substring(2);
    }

    private String[] splitStringArray(String s) {
        return s.split("\\},\\{");
    }

    private String[] convertToStringArray(String s) {
        return this.splitStringArray(this.removeSideMustache(s));
    }

    public int[] solution(String s) {
        String[] split = this.convertToStringArray(s);

        Arrays.sort(split, Comparator.comparing(String::length));

        List<String> answer = new ArrayList<>();
        for (String element : split) {
            for (String a : answer) {
                element = element.replace(a, "");
            }
            answer.add(element.replace(",", ""));
        }
        return answer.stream().mapToInt(Integer::parseInt).toArray();
    }
}
