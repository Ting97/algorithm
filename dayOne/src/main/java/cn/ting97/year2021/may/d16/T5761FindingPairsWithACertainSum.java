package cn.ting97.year2021.may.d16;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5761FindingPairsWithACertainSum
 * @Description 找出和为指定值的下标对
 * @date 2021-05-16
 */
public class T5761FindingPairsWithACertainSum {
    Map<Integer, Integer> map = new HashMap<>();
    int[] nums1;
    int[] nums2;

    public void FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int num = nums2[index];
        map.put(num, map.get(num) - 1);
        num += val;
        map.put(num, map.getOrDefault(num, 0) + 1);
        nums2[index] = num;
    }

    public int count(int tot) {
        int ans = 0;
        for (int num : nums1) {
            ans += map.getOrDefault(tot - num, 0);
        }
        return ans;
    }
}
