package cn.ting97.year2021.may.d9;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5750MaximumPopulationYear
 * @Description 人口最多的年份
 * @date 2021-05-09
 */
public class T5750MaximumPopulationYear {

    /**
     * 数据量比较小，可以使用暴力的解法
     *
     * @param logs 出生死亡范围
     * @return 人口最多的年份
     */
    public int maximumPopulation(int[][] logs) {
        int[] year = new int[110];
        int minYear = 1950;
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; ++i) {
                year[i - minYear]++;
            }
        }
        int ans = 0;
        int maxYear = 0;
        for (int i = 0; i < year.length; ++i) {
            if (maxYear < year[i]) {
                ans = minYear + i;
                maxYear = year[i];
            }
        }
        return ans;
    }

    /**
     * 使用差分的方法
     *
     * @param logs 死亡范围
     * @return 人口最多的年份
     */
    public int maximumPopulation1(int[][] logs) {
        // 求差分数组
        int[] dp = new int[110];
        int minYear = 1950;
        for (int[] log : logs) {
            dp[log[0] - minYear]++;
            dp[log[1] - minYear]--;
        }
        int max = 0, sum = 0, ans = 0;
        for (int i = 0; i < dp.length; ++i) {
            sum += dp[i];
            if (max < sum) {
                max = sum;
                ans = i + minYear;
            }
        }
        return ans;
    }

}
