package d20201215;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T
 * @Description leetCode20201215每日一题738
 * @date 2020-12-15
 */
public class T738MonotoneIncreasingDigits {

    /**
     * https://leetcode-cn.com/problems/monotone-increasing-digits/
     * 贪心+字符串处理
     *
     * @param N N大小
     * @return 最大数
     */
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
