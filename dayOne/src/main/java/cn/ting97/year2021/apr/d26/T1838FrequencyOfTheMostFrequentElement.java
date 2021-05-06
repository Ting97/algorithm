package cn.ting97.year2021.apr.d26;

import java.util.Arrays;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T1838FrequencyOfTheMostFrequentElement
 * @Description 最高频元素的频数
 * @date 2021-04-26
 */
public class T1838FrequencyOfTheMostFrequentElement {
    /**
     * 238周赛第二题
     * 性质：最高频的数字一定可以是元素中的数字
     * 题解：利用双指针确定频数
     *
     * @param nums 数组
     * @param k    步数
     * @return 最高频数
     */
    public int maxFrequency(int[] nums, int k) {
        int iIndex = 0;
        int jIndex = 1;
        int max = 1;
        int temp = 0;
        Arrays.sort(nums);
        for (; jIndex < nums.length; jIndex++) {
            temp += (jIndex - iIndex) * (nums[jIndex] - nums[jIndex - 1]);
            if (temp > k) {
                temp -= (nums[jIndex] - nums[iIndex]);
                iIndex++;
            }
            max = Math.max(max, jIndex - iIndex + 1);
        }
        return max;
    }
}
