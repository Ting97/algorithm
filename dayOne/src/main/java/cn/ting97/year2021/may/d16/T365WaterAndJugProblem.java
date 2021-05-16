package cn.ting97.year2021.may.d16;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T365WaterAndJugProblem
 * @Description 水壶问题
 * @date 2021-05-16
 */
public class T365WaterAndJugProblem {
    /**
     * 贝祖定理ax+by=z 有解当且仅当 zz 是 x, yx,y 的最大公约数的倍数。因此我们只需要找到 x, yx,y 的最大公约数并判断 zz 是否是它的倍数即可。
     *
     * @param x x
     * @param y y
     * @param z z
     * @return 结果
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }

}
