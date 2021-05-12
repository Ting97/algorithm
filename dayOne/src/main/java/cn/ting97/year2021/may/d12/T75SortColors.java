package cn.ting97.year2021.may.d12;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T75SortColors
 * @Description 颜色分类
 * @date 2021-05-12
 */
public class T75SortColors {
    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 1. 双指针 + 两次遍历
     *
     * @param nums 数组
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length && nums[j] != 0) {
            ++j;
        }
        while (j < nums.length) {
            if (nums[j] == 0) {
                swap(nums, i++, j);
            }
            ++j;
        }
        j = i;
        while (j < nums.length && nums[j] != 1) {
            ++j;
        }
        while (j < nums.length) {
            if (nums[j] == 1) {
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
