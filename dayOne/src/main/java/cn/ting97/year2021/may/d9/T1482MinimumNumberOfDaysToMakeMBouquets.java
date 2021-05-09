package cn.ting97.year2021.may.d9;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T1482MinimumNumberOfDaysToMakeMBouquets
 * @Description 制作 m 束花所需的最少天数
 * @date 2021-05-09
 */
public class T1482MinimumNumberOfDaysToMakeMBouquets {
    /**
     * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
     * <p>
     * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
     * <p>
     * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
     * <p>
     * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
     * <p>
     * 1. 采用二分法进行操作
     * 2. 二分边界是最大天数和最小天数
     *
     * @param bloomDay 花开的天数
     * @param m        m束花
     * @param k        相邻k朵🌹
     * @return 等待天数
     */
    public int minDays(int[] bloomDay, int m, int k) {
        int minDay = Integer.MAX_VALUE, maxDay = 0;
        for (int day : bloomDay) {
            maxDay = Math.max(maxDay, day);
            minDay = Math.min(minDay, day);
        }
        while (minDay < maxDay) {
            int day = minDay + ((maxDay - minDay) >> 1);
            if (checkDay(bloomDay, day, m, k)) {
                maxDay = day;
            } else {
                minDay = day + 1;
            }
        }
        if (checkDay(bloomDay, minDay, m, k)) {
            return minDay;
        }
        return -1;
    }

    private boolean checkDay(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int flowers = 0;
        for (int d : bloomDay) {
            if (d <= day) {
                flowers++;
                if (flowers == k) {
                    flowers = 0;
                    count++;
                }
            } else {
                flowers = 0;
            }
        }
        return count >= m;
    }
}
