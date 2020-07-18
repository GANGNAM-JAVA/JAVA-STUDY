package practice.incheol;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Incheol Jung
 */
public class Solution {
    public boolean isAnagramOrigin(String s, String t) {
        char[] beginCharArr = s.toCharArray();
        char[] targetCharArr = t.toCharArray();

        if(beginCharArr.length != targetCharArr.length) return false;

        Arrays.sort(beginCharArr);
        Arrays.sort(targetCharArr);

        for(int i=0; i< beginCharArr.length; i++){
            if(beginCharArr[i] != targetCharArr[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        char[] beginCharArr = s.toCharArray();
        char[] targetCharArr = t.toCharArray();
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();

        if (beginCharArr.length != targetCharArr.length)
            return false;

        for (int i = 0; i < beginCharArr.length; i++) {
            countMap.put(beginCharArr[i] ,countMap.getOrDefault(beginCharArr[i], 0) + 1);
            countMap.put(targetCharArr[i] ,countMap.getOrDefault(targetCharArr[i], 0) - 1);
        }
//        Integer Zero = new Integer(0);
//        return !countMap.entrySet().stream()
//                .anyMatch(charCount -> !charCount.getValue().equals(Zero));

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isAnagram("anagram","nagaram"));
    }
}
