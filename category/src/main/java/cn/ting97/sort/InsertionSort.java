package cn.ting97.sort;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className InsertSort
 * @Description 插入排序
 * @date 2021-06-09
 */
public class InsertionSort {
    /**
     * 插入排序
     * 稳定性：稳定
     * 复杂度：O(n)
     * 一般作为快速排序的扩展：
     *      1. 在STL的sort算法和stdlib的qsort算法中，都将插入排序作为快速排序的补充，用于少量元素的排序。
     *      2. 在JDK 7 java.util.Arrays所用的sort方法的实现中，当待排数组长度小于47时，会使用插入排序。
     * @param arr 数组
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int position = i;
            while (position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position--;
            }
            arr[position] = value;
        }
    }
}
