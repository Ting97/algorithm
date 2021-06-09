package cn.ting97.year2021;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className cn.ting97.year2021.T1696MaxResult
 * @Description
 * @date 2020-12-21
 */
public class T1696MaxResult {
    /**
     * https://leetcode-cn.com/problems/jump-game-vi/
     * [1,-1,-2,4,-7,3]
     * 2
     *
     * @param nums 花费
     * @param k    每次最大步数
     * @return 最大花费
     */
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length + 1];
        List<Integer> list = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                Integer it = list.remove(0);
                if (it == max) {
                    max = getMax(list);
                }
            }
            dp[i] = max + nums[i];
            list.add(dp[i]);
            max = Math.max(dp[i], max);
        }
        return dp[nums.length - 1];
    }

    private int getMax(List<Integer> nums) {
        int res = Integer.MIN_VALUE;
        for (Integer num : nums) {
            res = Math.max(res, num);
        }
        return res;
    }
}
