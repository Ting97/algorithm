package cn.ting97.year2021.may.d9;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5751MaximumDistanceBetweenAPairOfValues
 * @Description 下标对中的最大距离
 * @date 2021-05-09
 */
public class T5751MaximumDistanceBetweenAPairOfValues {
    /**
     * 给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。
     * <p>
     * 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i​​ 。​​
     * <p>
     * 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
     * <p>
     * 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
     * <p>
     * 1. 遍历二分
     *
     * @param nums1 数组一
     * @param nums2 数组二
     * @return 下标对中的最大距离
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.length; ++i) {
            if (nums2.length - i < ans) {
                return ans;
            }
            int left = i + ans;
            int right = nums2.length - 1;
            while (left < right) {
                int mid = (left + right - 1) / 2 + 1;
                if (nums1[i] <= nums2[mid]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (left < nums2.length && nums1[i] <= nums2[left]) {
                ans = left - i;
            }
        }
        return ans;
    }

    /**
     * 双指针算法
     *
     * @param nums1 数组一
     * @param nums2 数组二
     * @return 下标对中的最大距离
     */
    public int maxDistance1(int[] nums1, int[] nums2) {
        int ans = 0;
        for (int i = nums1.length - 1, j = nums2.length - 1; i >= 0 && j >= 0; ) {
            if (nums1[i] <= nums2[j]) {
                ans = Math.max(ans, j - i);
                --i;
            } else {
                --j;
            }
        }
        return ans;
    }
}
