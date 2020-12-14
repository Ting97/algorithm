import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T49GroupAnagrams
 * @Description leetCode20201214每日一题49
 * @date 2020-12-14
 */
public class T49GroupAnagrams {
    /**
     * https://leetcode-cn.com/problems/group-anagrams/
     * 排序
     *
     * @param strs 字符数组
     * @return 分类后的列表
     */
    public List<List<String>> groupAnagrams0(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * https://leetcode-cn.com/problems/group-anagrams/
     * 计数
     *
     * @param strs 字符数组
     * @return 分类后的列表
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int[] nums = new int[26];
            for (char aChar : chars) {
                nums[aChar - 'a']++;
            }
            String s = Arrays.toString(nums);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * https://leetcode-cn.com/problems/group-anagrams/
     * lambda 1
     *
     * @param strs 字符数组
     * @return 分类后的列表
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }

    /**
     * https://leetcode-cn.com/problems/group-anagrams/
     * lambda 2
     *
     * @param strs 字符数组
     * @return 分类后的列表
     */
    public List<List<String>> groupAnagrams3(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str ->
                        str.chars().sorted()
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                .toString())).values());
    }
}
