package cn.ting97.year2020.dec.d24;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T135Candy
 * @Description TODO
 * @date 2020-12-25
 */
public class T135Candy {
    /**
     * https://leetcode-cn.com/problems/candy/
     * 分发糖果
     * TODO 学习，了解
     *
     * @param ratings 分数
     * @return 糖果数
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }
}
