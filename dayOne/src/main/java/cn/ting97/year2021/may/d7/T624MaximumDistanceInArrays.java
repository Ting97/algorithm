package cn.ting97.year2021.may.d7;

import java.util.List;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T624MaximumDistanceInArrays
 * @Description 数组列表中的最大距离
 * @date 2021-05-07
 */
public class T624MaximumDistanceInArrays {
    /**
     * 给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。你的任务就是去找到最大距离
     *
     * 1. curMax = Math.max(preMax - curMin, curMax - preMin);
     * 2. max = Math.max(max, curMax);
     * @param arrays m个数组
     * @return 最大距离
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int preMax = -10001;
        int preMin = 10001;
        for (List<Integer> list : arrays) {
            Integer curMin = list.get(0);
            Integer curMax = list.get(list.size() - 1);
            int curAns = Math.max(preMax - curMin, curMax - preMin);
            ans = Math.max(ans, curAns);
            preMax = Math.max(preMax, curMax);
            preMin = Math.min(preMin, curMin);
        }
        return ans;
    }
}
