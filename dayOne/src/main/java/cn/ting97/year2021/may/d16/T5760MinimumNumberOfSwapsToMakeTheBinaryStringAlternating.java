package cn.ting97.year2021.may.d16;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5760MinimumNumberOfSwapsToMakeTheBinaryStringAlternating
 * @Description 构成交替字符串需要的最小交换次数
 * @date 2021-05-16
 */
public class T5760MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {
    /**
     * 结果类型+判断
     *
     * @param s 二进制字符串
     * @return 结果
     */
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        int left = 0;
        int right = 0;
        // 计算1个数 偶数1个数 奇数1个数
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                num++;
                left = i % 2 == 0 ? left + 1 : left;
                right = i % 2 == 0 ? right : right + 1;
            }
        }
        // 根据情况进行解答
        if (chars.length % 2 == 1) {
            if (num == chars.length / 2) {
                return left;
            } else if (num == chars.length / 2 + 1) {
                return right;
            } else {
                return -1;
            }
        } else {
            if (num == chars.length / 2) {
                return Math.min(left, right);
            } else {
                return -1;
            }
        }
    }
}
