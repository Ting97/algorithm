package cn.ting97.year2021.aug.d7;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T213HouseRobberII
 * @Description 打家劫舍 II
 * @date 2021-05-07
 */
public class T213HouseRobberII {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * <p>
     * 1. 屋子围成一圈，取 0 - (length - 2) 和 1 - （length - 1）即可
     * 2. 无后效性
     *
     * @param nums 房子价值
     * @return 最高偷窃金额
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    /**
     * 范围在 [left, right] 的最大偷窃金额
     * 房子围成一排即可
     *
     * @param nums  价值
     * @param left  左
     * @param right 右
     * @return 最大偷窃金额
     */
    private int rob(int[] nums, int left, int right) {
        int first = nums[left];
        int second = Math.max(first, nums[left + 1]);
        for (int i = left + 2; i <= right; ++i) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
