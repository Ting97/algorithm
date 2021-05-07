package cn.ting97.year2021.aug.d7;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className MT0107RotateMatrixLCCI
 * @Description 旋转矩阵
 * @date 2021-05-07
 */
public class MT0107RotateMatrixLCCI {
    /**
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     * <p>
     * 不占用额外内存空间能否做到？
     * <p>
     * 1. 按照 x=y 轴翻转
     * 2. 根据 x=mid 翻转
     *
     * @param matrix 矩阵
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 按照 x=y 翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                swap(matrix, j, i, i, j);
            }
        }
        // 按照 x = mid 翻转
        for (int i = 0; i < n; ++i) {
            int mid = n >> 1;
            for (int j = 0; j < mid; ++j) {
                swap(matrix, j, i, n - j - 1, i);
            }
        }
    }

    /**
     * 交换矩阵坐标的值
     *
     * @param matrix 矩阵
     * @param x1     原x1
     * @param y1     原y1
     * @param x2     替换x2
     * @param y2     替换y2
     */
    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[y1][x1];
        matrix[y1][x1] = matrix[y2][x2];
        matrix[y2][x2] = temp;
    }
}
