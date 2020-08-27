package K1.incheol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

/**
 * @author Incheol Jung
 */
public class Solution {
    private static final List<Integer> LEFT_RANGE = new ArrayList<Integer>(Arrays.asList(1, 4, 7));
    private static final List<Integer> RIGHT_RANGE = new ArrayList<Integer>(Arrays.asList(3, 6, 9));

    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        System.out.println(result);
    }

    private enum Side {
        left,
        right,
        middle
    }

    private enum Hand {
        left("left"),
        right("right");

        final private String side;

        Hand(String side) {
            this.side = side;
        }

        public String getValue() {
            return this.side;
        }
    }

    private enum PhoneBook {
        ONE("1", 1),
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        ASTRO("*", 10),
        ZERO("0", 11),
        SHARP("#", 12);

        final private String phoneNumber;
        final private Integer value;

        PhoneBook(String phoneNumber, Integer value) {
            this.phoneNumber = phoneNumber;
            this.value = value;
        }

        public static Optional<PhoneBook> findByPhoneNumber(String phoneNumber) {
            return Arrays.stream(PhoneBook.values())
                         .filter(phoneBook -> phoneBook.phoneNumber.equals(phoneNumber))
                         .findFirst();
        }

    }

    private Side whichSide(int num) {
        if (LEFT_RANGE.contains(num)) {
            return Side.left;
        } else if (RIGHT_RANGE.contains(num)) {
            return Side.right;
        } else {
            return Side.middle;
        }
    }

    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        Stack<PhoneBook> leftHand = new Stack<>();
        leftHand.push(PhoneBook.ASTRO);
        Stack<PhoneBook> rightHand = new Stack<>();
        rightHand.push(PhoneBook.SHARP);

        for (int number : numbers) {
            PhoneBook currentPhoneBook = PhoneBook.findByPhoneNumber(String.valueOf(number)).get();
            switch (whichSide(currentPhoneBook.value)){
                case left:
                    setupSide(answer, "L", leftHand, currentPhoneBook);
                    break;
                case right:
                    setupSide(answer, "R", rightHand, currentPhoneBook);
                    break;
                case middle:
                    int leftHandCount = countDistance(leftHand.peek(), currentPhoneBook.value);
                    int rightHandCount = countDistance(rightHand.peek(), currentPhoneBook.value);

                    if (leftHandCount > rightHandCount) {
                        setupSide(answer, "R", rightHand, currentPhoneBook);
                    } else if (leftHandCount < rightHandCount) {
                        setupSide(answer, "L", leftHand, currentPhoneBook);
                    } else {
                        if (hand.equals(Hand.left.getValue())) {
                            setupSide(answer, "L", leftHand, currentPhoneBook);
                        } else {
                            setupSide(answer, "R", rightHand, currentPhoneBook);
                        }
                    }
                    break;
            }
        }

        return answer.toString();
    }

    private void setupSide(StringBuffer answer, String str, Stack<PhoneBook> hand, PhoneBook currentPhoneBook){
        answer.append(str);
        hand.push(currentPhoneBook);
    }

    private Integer countDistance(PhoneBook currentNumber, int targetNumber) {
        int distance = Math.abs(currentNumber.value - targetNumber);
        int rest = distance / 3;
        int remain = distance % 3;
        return rest + remain;
    }
}
