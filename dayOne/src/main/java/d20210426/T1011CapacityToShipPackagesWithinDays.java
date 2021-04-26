package d20210426;

import java.util.Arrays;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T1011CapacityToShipPackagesWithinDDays
 * @Description 在 D 天内送达包裹的能力
 * @date 2021-04-26
 */
public class T1011CapacityToShipPackagesWithinDays {
    /**
     * 在 D 天内送达包裹的能力.
     * 1. 二分法，边界： 最大的包裹重量 和 所有的包裹重量 进行二分
     * 2. 如果按照当前中间值作为承载重量进行计算的所需天数 小于等于 给定天数，舍弃大于中间值的部分
     * 3. 如果按照当前中间值作为承载重量进行计算的所需天数 大于 给定天数，舍弃小于中间值的部分
     *
     * @param weights 物体重量
     * @param D       天数
     * @return 最大载重
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // 需要运送的天数，当天运送包裹总和
            int days = 1;
            int cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++days;
                    cur = 0;
                }
                cur += weight;
            }
            if (days <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
