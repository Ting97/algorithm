package cn.ting97.year2021.may.d8;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T28ImplementStrStr
 * @Description 实现 strStr()
 * @date 2021-05-08
 */
public class T28ImplementStrStr {
    /**
     * 实现 strStr() 函数。
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     * 说明
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     *
     * @param haystack 源字符串
     * @param needle   目标字符串
     * @return 下标
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
