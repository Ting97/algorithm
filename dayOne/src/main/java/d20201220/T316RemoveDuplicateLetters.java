package d20201220;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T316RemoveDuplicateLetters
 * @Description
 * @date 2020-12-20
 */
public class T316RemoveDuplicateLetters {

    // TODO: 2020/12/20 opt
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (char aChar : chars) {
            nums[aChar - 'a']++;
        }
        stack.push(chars[0]);
        nums[chars[0] - 'a']--;
        for (int i = 1; i < chars.length; i++) {
            if (!stack.contains(chars[i])) {
                while (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek > chars[i] && nums[peek - 'a'] >= 1) {
                        stack.pop();
                        continue;
                    }
                    break;
                }
                stack.push(chars[i]);
            }
            nums[chars[i] - 'a']--;
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

    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {

                Integer k = set.stream().reduce(Integer::sum).get();
                max  = Math.max(max, k);
                set.clear();
                set.add(nums[i-1]);
            } else {
                set.add(nums[i]);
                Integer k = set.stream().reduce(Integer::sum).get();
                max  = Math.max(max, k);
            }
        }
        return max;
    }
    public int maxResult(int[] nums, int k) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
        }
        return res;
    }
}
