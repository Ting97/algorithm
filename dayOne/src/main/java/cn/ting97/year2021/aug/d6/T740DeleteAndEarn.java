package cn.ting97.year2021.aug.d6;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T740DeleteAndEarn
 * @Description 删除并获得点数
 * @date 2021-05-06
 */
public class T740DeleteAndEarn {
    /**
     * 删除并获得点数
     * <p>
     * 给你一个整数数组 nums ，你可以对它进行一些操作。
     * <p>
     * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
     * <p>
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     * 1 <= nums.length <= 2 * 104
     * 1 <= nums[i] <= 104
     * <p>
     * 1. 利用桶思想进行统计每个数的个数
     * 2. 相邻桶不可同时取
     * 3. max = Math(first + nums[i] * i, second);
     *
     * @param nums 整数数组
     * @return 最大点数
     */
    public int deleteAndEarn(int[] nums) {
        // 初始化 & 统计
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        // 计算
        int first = 0, second = count[1];
        for (int i = 2; i < count.length; ++i) {
            int temp = second;
            second = Math.max(first + count[i] * i, second);
            first = temp;
        }
        return second;
    }
}
