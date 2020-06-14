/**
 *  @author leekyunghee
 *  @Date 2020-06-13
 *  참가자 이름을 key로 하여 참가자 명단수를 count 한다.
 *  key를 가지지 않는 map이므로 getOrDefault 메소드를 사용하여 +1 값을 map에 담는다.
 *  캐시된 맵에서 완주한 사람을 제거 (참가자 명단에 완주한 사람이 포함되어 있으므로 -1)
 */

package incompletePlayer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};


        imcompletePlayers(participant, completion);

    }
    public static String imcompletePlayers(String[] participant, String[] completion) {
        String player = "";
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String name : participant) {
            map.put(name, map.getOrDefault(name,0)+1);
        }

        for(String name : completion) {
            map.put(name, map.get(name)-1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                player = key;
            }
        }

        return player;
    }
}