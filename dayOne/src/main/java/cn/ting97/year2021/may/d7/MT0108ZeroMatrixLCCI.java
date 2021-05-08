package cn.ting97.year2021.may.d7;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className MT0108ZeroMatrixLCCI
 * @Description 零矩阵
 * @date 2021-05-07
 */
public class MT0108ZeroMatrixLCCI {
    /**
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     *
     * @param matrix 矩阵
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] mz = new boolean[m];
        boolean[] nz = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    mz[i] = true;
                    nz[j] = true;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = mz[i] || nz[j] ? 0 : matrix[i][j];
            }
        }
    }
}
