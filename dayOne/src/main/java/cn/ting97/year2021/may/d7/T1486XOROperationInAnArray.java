package cn.ting97.year2021.may.d7;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className XOROperationInAnArray
 * @Description 数组异或操作
 * @date 2021-05-07
 */
public class T1486XOROperationInAnArray {
    /**
     * 给你两个整数，n 和 start 。
     * <p>
     * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
     * <p>
     * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     * <p>
     * 1. 模拟
     *
     * @param n     n个数
     * @param start 起始数
     * @return 异或后的结果
     */
    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans ^= start + (i << 1);
        }
        return ans;
    }
}
