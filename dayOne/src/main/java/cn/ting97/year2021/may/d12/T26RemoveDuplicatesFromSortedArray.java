package cn.ting97.year2021.may.d12;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T26RemoveDuplicatesFromSortedArray
 * @Description 删除有序数组中的重复项
 * @date 2021-05-12
 */
public class T26RemoveDuplicatesFromSortedArray {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 1. 双指针
     *
     * @param nums 数组
     * @return 结果
     */
    public int removeDuplicates(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[ans] != nums[i]) {
                nums[++ans] = nums[i];
            }
        }
        return ++ans;
    }
}
