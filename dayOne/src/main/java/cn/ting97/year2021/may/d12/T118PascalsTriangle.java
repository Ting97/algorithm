package cn.ting97.year2021.may.d12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T118PascalsTriangle
 * @Description 杨辉三角
 * @date 2021-05-12
 */
public class T118PascalsTriangle {
    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * <p>
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 1. 模拟
     *
     * @param numRows 行数
     * @return 结果
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        List<Integer> preList = list;
        for (int i = 1; i < numRows; ++i) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 0; j < i - 1; ++j) {
                list.add(preList.get(j) + preList.get(j + 1));
            }
            list.add(1);
            ans.add(list);
            preList = list;
        }
        return ans;
    }
}
