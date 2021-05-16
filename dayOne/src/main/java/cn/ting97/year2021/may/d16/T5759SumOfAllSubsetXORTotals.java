package cn.ting97.year2021.may.d16;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5759SumOfAllSubsetXORTotals
 * @Description 找出所有子集的异或总和再求和
 * @date 2021-05-16
 */
public class T5759SumOfAllSubsetXORTotals {
    /**
     * 二进制思想
     *
     * @param nums 数组
     * @return 结果
     */
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int k = 1 << n;
        int ans = 0;
        for (int i = 1; i < k; ++i) {
            int sum = 0;
            int m = 0;
            int i1 = i >> m;
            while (i1 > 0) {
                if (i1 % 2 == 1) {
                    sum ^= nums[m];
                }
                m++;
                i1 = i >> m;
            }
            ans += sum;
        }
        return ans;
    }
}
