package cn.ting97.year2021.may.d8;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T485MaxConsecutiveOnes
 * @Description 最大连续 1 的个数
 * @date 2021-05-08
 */
public class T485MaxConsecutiveOnes {
    /**
     * 给定一个二进制数组， 计算其中最大连续 1 的个数。
     *
     * @param nums 二进制数组
     * @return 连续1个数
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int sum = 0;
        for (int num : nums) {
            sum = num == 1 ? sum + 1 : 0;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && nums[j] == 1) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j;
        }
        return res;
    }
}
