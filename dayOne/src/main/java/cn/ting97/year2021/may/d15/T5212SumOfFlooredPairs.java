package cn.ting97.year2021.may.d15;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5212SumOfFlooredPairs
 * @Description 向下取整数对和
 * @date 2021-05-16
 */
public class T5212SumOfFlooredPairs {

    private static final int MOD = 1000000007;

    /**
     * 给你一个整数数组 nums ，请你返回所有下标对 0 <= i, j < nums.length 的 floor(nums[i] / nums[j]) 结果之和。由于答案可能会很大，请你返回答案对109 + 7 取余 的结果。
     * <p>
     * 函数 floor() 返回输入数字的整数部分。
     *
     * @param nums 数组
     * @return 结果
     */
    public int sumOfFlooredPairs(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] sums = new int[max + 1];
        for (int num : nums) {
            sums[num]++;
        }
        int[] sumss = new int[max + 1];
        sumss[0] = sums[0];
        for (int i = 1; i < sumss.length; ++i) {
            sumss[i] = sumss[i - 1] + sums[i];
        }
        long ans = 0;
        for (int num : nums) {
            for (int i = 1; i * num <= max; ++i) {
                int ma = Math.min((i + 1) * num - 1, max);
                ans += (long) (sumss[ma] - sumss[i * num - 1]) * i;
                ans %= MOD;
            }
        }
        return (int) ans;
    }
}
