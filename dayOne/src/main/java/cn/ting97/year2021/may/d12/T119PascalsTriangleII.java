package cn.ting97.year2021.may.d12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T119PascalsTriangleII
 * @Description 杨辉三角 II
 * @date 2021-05-12
 */
public class T119PascalsTriangleII {

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     *
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 1. 模拟
     * @param rowIndex 行数
     * @return 结果
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
