package cn.ting97.year2021.may.d6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T220ContainsDuplicateIII
 * @Description 存在重复元素 III
 * @date 2021-05-06
 */
public class T220ContainsDuplicateIII {
    /**
     * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
     * <p>
     * 根据桶思想
     * 1. 设定每个桶的容量为 t+1， 每个桶只存放一个物品
     * 2. 如果桶存在，则一定有
     * 3. 如果相邻桶存在，则需要比较大小
     * 4. 遍历一遍所有数，即可判断是否存在
     *
     * @param nums 整数数组
     * @param k    abs(i - j) <= k
     * @param t    abs(nums[i] - nums[j]) <= t
     * @return 是否存在
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        long w = t + 1;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            long id = getID(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) <= t) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) <= t) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    /**
     * 返回桶ID
     *
     * @param x 重量
     * @param w 桶大小
     * @return 桶ID
     */
    private long getID(long x, long w) {
        return x >= 0 ? x / w : (x + 1) / w - 1;
    }
}
