package cn.ting97.year2021.may.d16;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T421MaximumXOROfTwoNumbersInAnArray
 * @Description 数组中两个数的最大异或值
 * @date 2021-05-16
 */
public class T421MaximumXOROfTwoNumbersInAnArray {
    class Tire {
        Tire left = null;
        Tire right = null;
    }

    Tire root = new Tire();
    final int key = 30;

    /**
     * 官方题解
     *
     * @param nums 数组
     * @return 结果
     */
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int i : nums) {
            add(i);
        }
        for (int i : nums) {
            res = Math.max(res, check(i));
        }
        return res;
    }

    public void add(int num) {
        Tire cur = root;
        for (int i = key; i >= 0; i--) {
            int val = (num >> i) & 1;
            if (val == 0) {
                if (cur.left == null) {
                    Tire node = new Tire();
                    cur.left = node;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    Tire node = new Tire();
                    cur.right = node;
                }
                cur = cur.right;
            }
        }
    }

    public int check(int num) {
        Tire cur = root;
        int res = 0;
        for (int i = key; i >= 0; i--) {
            int x = num >> i & 1;
            if (x == 0) {
                if (cur.right != null) {
                    cur = cur.right;
                    res = res * 2 + 1;
                } else {
                    cur = cur.left;
                    res = res * 2;
                }
            } else {
                if (cur.left != null) {
                    cur = cur.left;
                    res = res * 2 + 1;
                } else {
                    cur = cur.right;
                    res = res * 2;
                }
            }
        }
        return res;
    }
}
