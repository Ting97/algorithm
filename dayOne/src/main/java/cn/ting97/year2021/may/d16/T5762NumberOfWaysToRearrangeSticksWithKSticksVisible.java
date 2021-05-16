package cn.ting97.year2021.may.d16;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5762NumberOfWaysToRearrangeSticksWithKSticksVisible
 * @Description 恰有 K 根木棍可以看到的排列数目
 * @date 2021-05-16
 */
public class T5762NumberOfWaysToRearrangeSticksWithKSticksVisible {
    public static final int MOD = 1000000007;

    /**
     * 动态规划
     * i表示第i位， j表示该位前可以看到多少根 f(i,j) = f(i - 1, j - 1) + (i - 1) * f(i - 1, j);
     *
     * @param n 总共根数
     * @param k 看到的根数
     * @return 结果
     */
    public int rearrangeSticks(int n, int k) {
        long[][] f = new long[n + 1][k + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                f[i][j] = (f[i - 1][j - 1] + (i - 1) * f[i - 1][j]) % MOD;
            }
        }
        return (int) f[n][k];
    }
}
