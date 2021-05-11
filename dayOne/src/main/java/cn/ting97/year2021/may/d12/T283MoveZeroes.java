package cn.ting97.year2021.may.d12;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T283MoveZeroes
 * @Description 移动零
 * @date 2021-05-12
 */
public class T283MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 1. 双指针
     *
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for (; i < nums.length && nums[i] != 0; ++i)
            ;
        j = i + 1;
        while (j < nums.length) {
            if (nums[j] != 0) {
                swap(nums, i++, j);
            }
            ++j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
