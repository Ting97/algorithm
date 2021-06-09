package cn.ting97.sort;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className BubbleSort
 * @Description 冒泡算法
 * @date 2021-06-09
 */
public class BubbleSort {
    /**
     * 冒泡排序
     * 复杂度较高，一般情况下复杂度为 O(n^2)
     * 稳定性：在相邻元素相等时，它们并不会交换位置，所以，冒泡排序是稳定排序。
     *
     * @param arr 数据
     */
    public static void bubbleSortV1(int[] arr) {
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 改进的冒泡排序 有序的情况下复杂度为 O(n)
     * 判断已经有序时，不需要再冒泡，使用标志位swap
     *
     * @param arr 数组
     */
    public static void bubbleSortV2(int[] arr) {
        int temp;
        boolean swap;
        for (int i = arr.length - 1; i >= 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }
}