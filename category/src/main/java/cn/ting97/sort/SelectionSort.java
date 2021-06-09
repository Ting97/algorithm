package cn.ting97.sort;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className SelectionSort
 * @Description 选择排序
 * @date 2021-06-09
 */
public class SelectionSort {
    /**
     * 选择排序,每次选择最小的
     * 稳定性：不稳定
     * 复杂度：O(n^2)
     *
     * @param arr 数组
     */
    public static void selectionSortV1(int[] arr) {
        int temp, min;
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            min = i;
            for (int j = i + 1; j < length; ++j) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * 选择排序,每次选择最大的
     * 稳定性：不稳定
     * 复杂度：O(n^2)
     *
     * @param arr 数组
     */
    public static void selectionSortV2(int[] arr) {
        int temp, max;
        int length = arr.length;
        for (int i = length - 1; i > 0; i--) {
            max = i;
            for (int j = 0; j < i; ++j) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            if (max != i) {
                temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
    }
}
