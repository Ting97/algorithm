package cn.ting97.year2021.may.d15;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5744RotatingTheBox
 * @Description 旋转盒子
 * @date 2021-05-16
 */
public class T5744RotatingTheBox {

    private static final char STONE = '#';
    private static final char WALL = '*';
    private static final char BLANK = '.';

    /**
     * 模拟
     *
     * @param box 盒子
     * @return 旋转后的盒子
     */
    public char[][] rotateTheBox(char[][] box) {
        char[][] ans = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            for (int index = -1, iIndex = box.length - i - 1; index < box[i].length; ) {
                int size = index + 1;
                int stoneNum = 0;
                while (size < box[i].length && box[i][size] != WALL) {
                    if (box[i][size] == STONE) {
                        stoneNum++;
                    }
                    size++;
                }
                for (int j = size - 1; j > index && stoneNum > 0; --j, --stoneNum) {
                    ans[j][iIndex] = STONE;
                }
                if (size < box[i].length) {
                    ans[size][iIndex] = WALL;
                }
                index = size;
            }
        }
        for (char[] an : ans) {
            for (int i = 0; i < an.length; i++) {
                if (an[i] != WALL && an[i] != STONE) {
                    an[i] = BLANK;
                }
            }
        }
        return ans;
    }
}
