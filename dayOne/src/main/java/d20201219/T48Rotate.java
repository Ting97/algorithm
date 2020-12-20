package d20201219;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T48Rotate
 * @Description
 * @date 2020-12-19
 */
public class T48Rotate {
    /**
     * https://leetcode-cn.com/problems/rotate-image/submissions/
     * 中轴线翻转，右斜线翻转
     *
     * @param matrix 矩阵
     */
    public void rotate(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int i = 0; i < ints.length >> 1; i++) {
                int t = ints[i];
                ints[i] = ints[ints.length - i - 1];
                ints[ints.length - i - 1] = t;
            }
        }
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][length - 1 - i];
                matrix[length - 1 - j][length - 1 - i] = t;
            }
        }
    }

}
