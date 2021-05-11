package cn.ting97.year2021.may.d8;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5LongestPalindromicSubstring
 * @Description 最长回文子串
 * @date 2021-05-08
 */
public class T5LongestPalindromicSubstring {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 1. 模拟思想算最大值
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        // 初始化，记录最长子串长度，剪枝
        int max = 0;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int n = chars.length;
        for (int i = 0; i < n; ++i) {
            int length = n - i;
            // 记录最长子串长度，减少重复计算
            for (int j = n - 1; j > i && length > max; --j, --length) {
                int iIndex = i;
                int jIndex = j;
                while (iIndex < jIndex && chars[iIndex++] == chars[jIndex--]);
                if (iIndex >= jIndex && chars[iIndex - 1] == chars[jIndex + 1]) {
                    max = length;
                    sb.delete(0, sb.length());
                    for (int k = i; k <= j; ++k) {
                        sb.append(chars[k]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
