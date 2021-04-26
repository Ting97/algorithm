package d20201220;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T316RemoveDuplicateLetters
 * @Description
 * @date 2020-12-20
 */
public class T316RemoveDuplicateLetters {

    private static final char A = 'a';

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (char aChar : chars) {
            nums[aChar - A]++;
        }
        stack.push(chars[0]);
        nums[chars[0] - A]--;
        for (int i = 1; i < chars.length; i++) {
            if (!stack.contains(chars[i])) {
                for (Character peek = stack.peek(); !stack.isEmpty() && peek > chars[i] && nums[peek - A] >= 1; peek = stack.peek()) {
                    stack.pop();
                }
                stack.push(chars[i]);
            }
            nums[chars[i] - A]--;
        }
        return stack.stream().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).reverse().toString();
    }

    public String reformatNumber(String number) {
        number = number.replace(" ", "");
        number = number.replace("-", "");
        if (number.length() < 3) {
            return number;
        }
        StringBuilder sb = new StringBuilder();
        int end = number.length() - (number.length() % 3);
        if (number.length() % 3 == 1) {
            end = number.length() - 4;
        }
        int pre = 0;
        for (int i = 3; i <= end; i += 3) {
            sb.append(number, pre, i).append("-");
            pre = i;
        }
        if (number.length() % 3 == 0) {
            sb.deleteCharAt(sb.length() - 1);
        } else if (number.length() % 3 == 1) {
            sb.append(number, number.length() - 4, number.length() - 2)
                    .append("-").append(number, number.length() - 2, number.length());
        } else {
            sb.append(number.substring(number.length() - 2));
        }
        return sb.toString();
    }
}
