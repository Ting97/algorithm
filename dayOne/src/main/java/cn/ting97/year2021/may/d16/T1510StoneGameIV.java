package cn.ting97.year2021.may.d16;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T1510StoneGameIV
 * @Description 石子游戏 IV
 * @date 2021-05-17
 */
public class T1510StoneGameIV {
    /**
     * 递归 f(n) = f(n - f(k^2)) == false
     * @param n n 个石子
     * @return 结果
     */
    public boolean winnerSquareGame(int n) {
        // f(n) = f(n - f(k^2)) == false
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        for (int i = 2;i < n + 1; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
