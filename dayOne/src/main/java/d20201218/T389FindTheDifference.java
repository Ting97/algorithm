package d20201218;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T389
 * @Description 寻找多余的字符
 * @date 2020-12-18
 */
public class T389FindTheDifference {
    /**
     * https://leetcode-cn.com/problems/find-the-difference/
     * 哈希求解
     *
     * @param s 字符串
     * @param t 字符串
     * @return 多余的字符
     */
    public char findTheDifference0(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for (int i = 0; i < sChar.length; i++) {
            tCount[tChar[i] - 'a']++;
            sCount[sChar[i] - 'a']++;
        }
        tCount[tChar[tChar.length - 1] - 'a']++;
        for (int i = 0; i < sCount.length; i++) {
            if (tCount[i] != sCount[i]) {
                return (char) (i + 'a');
            }
        }
        return 't';
    }

    /**
     * https://leetcode-cn.com/problems/find-the-difference/
     * 求和相减
     *
     * @param s 字符串
     * @param t 字符串
     * @return 多余的字符
     */
    public char findTheDifference1(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int sCount = 0, tCount = 0;
        for (int i = 0; i < sChar.length; i++) {
            sCount += sChar[i];
            tCount += tChar[i];
        }
        tCount += tChar[tChar.length - 1];
        return (char) (tCount - sCount);
    }

    /**
     * https://leetcode-cn.com/problems/find-the-difference/
     * 位运算 异或 ^
     *
     * @param s 字符串
     * @param t 字符串
     * @return 多余的字符
     */
    public char findTheDifference2(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int c = 0;
        for (int i = 0; i < sChar.length; i++) {
            c ^= sChar[i];
            c ^= tChar[i];
        }
        c ^= tChar[tChar.length - 1];
        return (char) c;
    }

    /**
     * https://leetcode-cn.com/problems/find-the-difference/
     * lambda 表达式
     *
     * @param s 字符串
     * @param t 字符串
     * @return 多余的字符
     */
    public char findTheDifference3(String s, String t) {
        return (char) (s + t).chars().reduce(0, (c, d) -> c ^ d);
    }
}
