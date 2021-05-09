package cn.ting97.year2021.may.d8;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T27RemoveElement
 * @Description 移除元素
 * @date 2021-05-08
 */
public class T27RemoveElement {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 1. 原地替换
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        for (; i <= j; ++i) {
            if (nums[i] == val) {
                swap(nums, i--, j--);
            }
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
