package cn.ting97.year2021.aug.d7;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T1014BestSightseeingPair
 * @Description 最佳观光组合
 * @date 2021-05-07
 */
public class T1014BestSightseeingPair {
    /**
     * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
     * <p>
     * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
     * <p>
     * 返回一对观光景点能取得的最高分。
     * <p>
     * 1. 利用当前解的无后效性思考
     * 2. ans = Math.max(ans, max + cur -1)
     * 3. max = Math.max(max - 1, cur)
     *
     * @param values 每个的评分
     * @return 最大分值
     */
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int max = 0;
        for (int cur : values) {
            ans = Math.max(ans, max + cur - 1);
            max = Math.max(max - 1, cur);
        }
        return ans;
    }
}
