package cn.ting97.year2021.may.d8;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T14LongestCommonPrefix
 * @Description 最长公共前缀
 * @date 2021-05-08
 */
public class T14LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 1. 长度计算最小值
     * 2. 竖排遍历
     *
     * @param strs 字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        for (String s : strs) {
            len = Math.min(s.length(), len);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; ++i) {
            int j = 0;
            char c = strs[0].charAt(i);
            while (j < strs.length && strs[j].charAt(i) == c) {
                ++j;
            }
            if (j != strs.length) {
                break;
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    /**
     * 二分
     *
     * @param strs 字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix1(String[] strs) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        for (String s : strs) {
            right = Math.min(right, s.length());
        }
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            String t = strs[0].substring(0, mid);
            boolean flag = true;
            for (String s : strs) {
                if (!s.substring(0, mid).equals(t)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return strs[0].substring(0, left);
    }
}
