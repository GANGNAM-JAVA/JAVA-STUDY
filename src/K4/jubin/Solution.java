package K4.jubin;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> cache = new LinkedList<>();

        for(String city: cities){
            String cityLower = city.toLowerCase();
            if(cache.contains(cityLower)){
                cache.remove(cityLower);
                answer += 1;
            }else{
                answer += 5;
            }
            cache.add(cityLower);
            if (cache.size() > cacheSize)
                cache.remove();
        }
        return answer;
    }
}