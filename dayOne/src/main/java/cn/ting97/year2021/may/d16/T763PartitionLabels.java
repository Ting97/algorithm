package cn.ting97.year2021.may.d16;

import java.util.*;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T763PartitionLabels
 * @Description 划分字母区间
 * @date 2021-05-17
 */
public class T763PartitionLabels {
    /**
     * 划分字母区间
     * @param s 模拟
     * @return 模拟
     */
    public List<Integer> partitionLabels(String s) {
        char[] cs = s.toCharArray();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            int[] range = map.get(cs[i]);
            if (range == null) {
                range = new int[2];
                range[0] = i;
            } else {
                range[1] = i;
            }
            map.put(cs[i], range);
        }
        List<int[]> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(o -> o[0]));
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < list.size(); ++i) {
            int[] range1 = list.get(i);
            if (i == 0 || range1[0] < right) {
                right = Math.max(right, range1[1]);
            } else {
                ans.add(right - left + 1);
                left = range1[0];
                right = Math.max(left, range1[1]);
            }
        }
        ans.add(right - left + 1);
        return ans;
    }
}
