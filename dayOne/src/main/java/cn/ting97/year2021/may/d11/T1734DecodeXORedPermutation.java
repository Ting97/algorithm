package cn.ting97.year2021.may.d11;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T1734DecodeXORedPermutation
 * @Description 解码异或后的排列
 * @date 2021-05-11
 */
public class T1734DecodeXORedPermutation {
    /**
     * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
     * <p>
     * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
     * <p>
     * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
     * <p>
     * 1. 根据异或的性质，只要获取解码后的第一个值即可递推获得解码后的数组
     * 2. 根据异或的性质计算，encoded 的偶数位异或后得到的是答案除首个数字的所有异或值
     * 3. 前 n 个数异或后，即可获得答案的第一个值
     *
     * @param encoded 编码后的数组
     * @return 解码后的数组
     */
    public int[] decode(int[] encoded) {
        int first = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            first ^= encoded[i];
        }
        for (int i = 1; i <= encoded.length + 1; ++i) {
            first ^= i;
        }
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 0; i < encoded.length; ++i) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;
    }
}
