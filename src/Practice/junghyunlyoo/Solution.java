package search;
/*
 * @USER JungHyun
 * @DATE 2020-07-18
 * @DESCRIPTION
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    boolean isAnagram_hashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : sArray) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (char c : tArray) {
            Integer integer = sMap.get(c);
            if (Objects.isNull(integer) || integer == 0) {
                return false;
            }
            if (integer == 1) {
                sMap.remove(c);
            } else {
                sMap.put(c, integer - 1);
            }
        }
        return sMap.size() == 0;
    }

    boolean isAnagram_quickSort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        int length = sArray.length;
        for (int i = 0; i < length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
}
