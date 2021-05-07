package cn.ting97.year2021.aug.d7;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T403FrogJump
 * @Description 青蛙过河
 * @date 2021-05-07
 */
public class T403FrogJump {
    /**
     * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
     * <p>
     * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
     * <p>
     * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
     * <p>
     * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
     * <p>
     * 1. 动态规划， 判断每个石子是否可以由上一个石子跳跃后获取
     *
     * @param stones 石子位置
     * @return 是否可以达到终点
     */
    public boolean canCross(int[] stones) {
        // 边界判定
        int n = stones.length;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        // dp[i][j] 表示 是否可以到达i个石子，并且上一次跳跃的步数为j
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            // 遍历 i - 1 到 0 看是否可以从前面的石子条到当前石子
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                // 第 j 个石子最大可以跳跃 j + 1步
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (dp[i][k] && i == n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
