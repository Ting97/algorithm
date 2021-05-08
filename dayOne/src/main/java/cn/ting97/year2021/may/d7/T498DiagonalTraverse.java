package cn.ting97.year2021.may.d7;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T498DiagonalTraverse
 * @Description 对角线遍历
 * @date 2021-05-07
 */
public class T498DiagonalTraverse {
    /**
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     *
     * @param mat 矩阵
     * @return 返回对角线遍历
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        int x, y;
        for (int i = 0; i < m + n - 1; ++i) {
            if (i % 2 == 0) {
                y = Math.min(i, m - 1);
                x = i - y;
                while (y >= 0 && x < n) {
                    ans[index++] = mat[y--][x++];
                }
            } else {
                x = Math.min(i, n - 1);
                y = i - x;
                while (x >= 0 && y < m) {
                    ans[index++] = mat[y++][x--];
                }
            }
        }
        return ans;
    }
}
