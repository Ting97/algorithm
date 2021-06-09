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
     *
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

    public boolean checkZeroOnes(String s) {
        int one = 0;
        int zero = 0;
        int k = 0, t = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') {
                k++;
                t = 0;
                one = Math.max(k, one);
            } else {
                t++;
                k = 0;
                zero = Math.max(zero, t);
            }
        }
        return one > zero;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 > hour) {
            return -1;
        }
        int left = 1, right = 0;
        for (int d : dist) {
            right = Math.max(right, d);
        }
        right *= 100;
        while (left < right) {
            int mid = (left + right) / 2;
            System.out.println("left +\" \"+ right + \" \" + mid = " + left + " " + right + " " + mid);
            double h = 0;
            for (int i = 0; i < dist.length; ++i) {
                if (i == dist.length - 1) {
                    h += (double) dist[i] / (double) mid;
                } else {
                    h += dist[i] % mid == 0 ? dist[i] / mid : dist[i] / mid + 1;
                }
            }
            if (h > hour) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for (int i = 0, max = 0; i < s.length(); i++) {
            if (dp[i]) {
                for (int j = Math.max(max, i + minJump); j <= Math.min(i + maxJump, s.length() - 1); j++) {
                    if (s.charAt(j) == '0') {
                        dp[j] = true;
                    }
                    max = Math.max(max, j);
                }
            }
        }
        return dp[s.length() - 1];
    }
}
