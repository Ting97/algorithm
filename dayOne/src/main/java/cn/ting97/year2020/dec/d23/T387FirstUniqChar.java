package cn.ting97.year2020.dec.d23;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T387FirstUniqChar
 * @Description 字符串中的第一个唯一字符
 * @date 2020-12-24
 */
public class T387FirstUniqChar {
    /**
     * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
     *
     * @param s 字符串
     * @return 下标
     */
    public int firstUniqChar(String s) {
        int[] times = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            times[c - 'a']++;
        }
        for (int i = 0; i < cs.length; ++i) {
            if (times[cs[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
