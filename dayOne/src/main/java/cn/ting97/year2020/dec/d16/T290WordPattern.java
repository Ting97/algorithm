package cn.ting97.year2020.dec.d16;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T290WordPattern
 * @Description 单词规律
 * @date 2020-12-16
 */
public class T290WordPattern {
    /**
     * 两映射判断是否重复  2s
     * https://leetcode-cn.com/problems/word-pattern/
     *
     * @param pattern 单词规则
     * @param s       单词列表
     * @return 是否匹配
     */
    public boolean wordPattern0(String pattern, String s) {
        List<Integer> collect = pattern.chars().boxed().collect(Collectors.toList());
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String[] strings = s.split(" ");
        if (strings.length != collect.size()) {
            return false;
        }
        for (int i = 0; i < collect.size(); i++) {
            Integer key = collect.get(i);
            String string = strings[i];
            map1.putIfAbsent(key, strings[i]);
            if (!map1.get(key).equals(string)) {
                return false;
            }
            map2.putIfAbsent(string, key);
            if (!map2.get(string).equals(key)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 两映射判断是否重复  1s
     * https://leetcode-cn.com/problems/word-pattern/
     *
     * @param pattern 单词规则
     * @param s       单词列表
     * @return 是否匹配
     */
    public boolean wordPattern1(String pattern, String s) {
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }
        char[] patterns = pattern.toCharArray();
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < patterns.length; i++) {
            Character c = patterns[i];
            String value = strings[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(value)) {
                    return false;
                }
            } else {
                if (set.contains(value)) {
                    return false;
                }
                map.put(c, value);
                set.add(value);
            }
        }
        return true;
    }
}
