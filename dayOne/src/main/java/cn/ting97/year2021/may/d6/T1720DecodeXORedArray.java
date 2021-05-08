package cn.ting97.year2021.may.d6;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T1720DecodeXORedArray
 * @Description 解码异或后的数组
 * @date 2021-05-06
 */
public class T1720DecodeXORedArray {
    /**
     * 解码异或后的数组
     * <p>
     * 未知 整数数组 arr 由 n 个非负整数组成。
     * <p>
     * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
     * <p>
     * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
     * <p>
     * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
     *
     * @param encoded 编码后的数组
     * @param first   第一个解码
     * @return 解码后的数组
     */
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            ans[i + 1] = encoded[i] ^ ans[i];
        }
        return ans;
    }
}
