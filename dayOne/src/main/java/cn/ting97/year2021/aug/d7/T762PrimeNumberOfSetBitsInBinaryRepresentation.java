package cn.ting97.year2021.aug.d7;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T762PrimeNumberOfSetBitsInBinaryRepresentation
 * @Description 二进制表示中质数个计算置位
 * @date 2021-05-07
 */
public class T762PrimeNumberOfSetBitsInBinaryRepresentation {
    /**
     * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
     * <p>
     * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
     * <p>
     * 1. 利用bitCount统计一个数的计算置位
     * 2. 判断计算置位是否质数
     * 3. 循环遍历左右边界
     *
     * @param L 左边界
     * @param R 有边界
     * @return 计算置位为质数的个数
     */
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int i = L; i <= R; ++i) {
            ans += isPrime(Integer.bitCount(i), PrimeEnum.MOD_SIX) ? 1 : 0;
        }
        return ans;
    }

    private enum PrimeEnum {
        /**
         * 每次加1取模
         */
        MOD_ONE(),
        /**
         * 每次加2取模
         */
        MOD_TWO(),
        /**
         * 每次加6取模
         * n*6+2、n*6+4 可以被2整除
         * n*6+3 可以被3整除
         * 只需要处理 n*6+5 即可
         */
        MOD_SIX();
    }

    /**
     * 判断一个数是否质数
     * @param num 数
     * @param primeEnum 方法
     * @return 是否质数
     */
    private boolean isPrime(int num, PrimeEnum primeEnum) {
        if (num <= 3) {
            return num > 1;
        }
        int sqrt = (int) Math.sqrt(num);
        switch (primeEnum) {
            case MOD_ONE:
                for (int i = 2; i <= sqrt; ++i) {
                    if (num % i == 0) {
                        return false;
                    }
                }
                break;
            case MOD_TWO:
                if (num % 2 == 0) {
                    return false;
                }
                for (int i = 3; i <= sqrt; i += 2) {
                    if (num % i == 0) {
                        return false;
                    }
                }
                break;
            case MOD_SIX:
                if (num % 6 != 1 && num % 6 != 5) {
                    return false;
                }
                for (int i = 5; i <= sqrt; i += 6) {
                    if (num % i == 0 || num % (i + 2) == 0) {
                        return false;
                    }
                }
                break;
            default:
                return false;
        }
        return true;
    }
}
