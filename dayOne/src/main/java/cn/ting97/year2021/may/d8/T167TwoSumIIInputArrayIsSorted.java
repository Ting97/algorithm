package cn.ting97.year2021.may.d8;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T167TwoSumIIInputArrayIsSorted
 * @Description 两数之和 II - 输入有序数组
 * @date 2021-05-08
 */
public class T167TwoSumIIInputArrayIsSorted {
    /**
     * 给定一个已按照 升序排列 的整数数组 numbers，请你从数组中找出两个数满足相加之和等于目标数 target 。
     * <p>
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     * <p>
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 目标坐标
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                ans[0] = i;
                ans[1] = j;
                break;
            } else if (sum > target) {
                --j;
            } else {
                ++i;
            }
        }
        return ans;
    }
}
