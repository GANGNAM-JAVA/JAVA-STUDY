package Q1.kyunghee;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};


        imcompletePlayers(participant, completion);

    }

    public static String imcompletePlayers(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i=0; i < completion.length; i++)  {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[i];
    }
}