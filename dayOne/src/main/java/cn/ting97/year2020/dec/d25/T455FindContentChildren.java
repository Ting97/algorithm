package cn.ting97.year2020.dec.d25;

import java.util.Arrays;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T455FindContentChildren
 * @Description 分发饼干
 * @date 2020-12-25
 */
public class T455FindContentChildren {
    /**
     * https://leetcode-cn.com/problems/assign-cookies/
     * 排序+贪心
     *
     * @param g 小朋友胃口
     * @param s 饼干大小
     * @return 最多分多少小朋友
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (s[j] >= g[i]) {
                i++;
                res++;
            }
        }
        return res;
    }
}
