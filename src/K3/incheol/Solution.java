package K3.incheol;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * @author Incheol Jung
 */
public class Solution {
    public int[] solution(String s) {
        String[] stringArray = s.replaceAll("\\{","").replaceAll("\\}","").split(",");
        Map<Integer, Long> maps = Arrays.stream(stringArray).map(Integer::valueOf).collect(Collectors.groupingBy(o -> o, counting()));
        return maps.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = sol.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        String result = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(result);
    }
}
