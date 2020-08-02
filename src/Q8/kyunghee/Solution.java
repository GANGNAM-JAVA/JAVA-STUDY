public class Solution {

    public int calPoints(String[] ops) {
        int[] points = new int[ops.length];
        int i = 0;

        for(String k : ops) {
            switch (k) {
                case "+":
                    points[i] = points[i-1] + points[i-2];
                    i++;
                    break;
                case "D":
                    points[i] = 2 * points[i-1];
                    i++;
                    break;
                case "C":
                    points[i-1] = 0;
                    i--;
                    break;
                default:
                    points[i] = Integer.parseInt(k);
                    i++;
            }
        }
        int sum = 0;

        for (int j = 0; j < points.length; j++) {
            sum += points[j];
        }
        return sum;
    }
}