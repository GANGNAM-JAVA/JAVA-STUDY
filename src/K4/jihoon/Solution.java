package K4.jihoon;

import java.util.*;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return 5 * cities.length;

        int answer = 0;
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.containsKey(city)) {
                answer += 1;
            } else {
                if (cache.size() >= cacheSize) {
                    int minValue = Integer.MAX_VALUE;
                    String minString = "";

                    for (Map.Entry<String, Integer> e : cache.entrySet()) {
                        if (e.getValue() < minValue) {
                            minString = e.getKey();
                            minValue = e.getValue();
                        }
                    }
                    cache.remove(minString);
                }
                answer += 5;
            }
            cache.put(city, i+1);
        }
        return answer;
    }
}