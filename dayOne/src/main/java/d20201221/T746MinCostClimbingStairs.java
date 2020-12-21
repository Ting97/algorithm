package d20201221;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T746MinCostClimbingStairs
 * @Description 用最小花费爬楼梯
 * @date 2020-12-21
 */
public class T746MinCostClimbingStairs {
    /**
     * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
     * 用最小花费爬楼梯
     *
     * @param cost 花费数组
     * @return 最小花费
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }
}
