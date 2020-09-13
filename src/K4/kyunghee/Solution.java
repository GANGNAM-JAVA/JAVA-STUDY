import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> cache = new ArrayList<>();

        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            String temp = city.toUpperCase();

            if (cache.contains(temp)) {
                cache.remove(temp);
                cache.add(temp);

                answer++;

            } else {
                if (cache.size() == cacheSize) cache.remove(0);
                cache.add(temp);

                answer += 5;
            }
        }

        return answer;
    }
}