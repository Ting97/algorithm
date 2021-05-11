package cn.ting97.year2021.may.d12;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T1310XORQueriesOfASubarray
 * @Description 子数组异或查询
 * @date 2021-05-12
 */
public class T1310XORQueriesOfASubarray {

    /**
     * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
     * <p>
     * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
     * <p>
     * 并返回一个包含给定查询 queries 所有结果的数组。
     * <p>
     * 1. 利用前缀和 和 异或的性质 进行计算
     *
     * @param arr     数组
     * @param queries 查询
     * @return 返回查询后的结果
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        // 前缀和
        int[] sum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; ++i) {
            sum[i + 1] = sum[i] ^ arr[i];
        }
        // 计算查询结果
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            ans[i] = sum[queries[i][1] + 1] ^ sum[queries[i][0]];
        }
        return ans;
    }
}
