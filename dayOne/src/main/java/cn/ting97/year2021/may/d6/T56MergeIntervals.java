package cn.ting97.year2021.may.d6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T56MergeIntervals
 * @Description 合并区间
 * @date 2021-05-06
 */
public class T56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 遍历计算
        List<int[]> ansList = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int[] nums : intervals) {
            // 下一个的右边界 和当前的左边界进行判断 是否需要合并
            int nextLeft = nums[0], nextRight = nums[1];
            if (nextLeft <= right) {
                right = Math.max(right, nextRight);
            } else {
                ansList.add(new int[]{left, right});
                left = nextLeft;
                right = nextRight;
            }
        }
        ansList.add(new int[]{left, right});
        int n = ansList.size();
        int[][] ans = new int[n][];
        for (int i = 0; i < n; ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
