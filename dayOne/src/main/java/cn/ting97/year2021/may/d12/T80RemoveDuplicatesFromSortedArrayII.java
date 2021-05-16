package cn.ting97.year2021.may.d12;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T80RemoveDuplicatesFromSortedArrayII
 * @Description 删除有序数组中的重复项 II
 * @date 2021-05-12
 */
public class T80RemoveDuplicatesFromSortedArrayII {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 1. 双指针
     *
     * @param nums 数组
     * @return 完成后的数组大小
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
            ++fast;
        }
        return slow;
    }
}
