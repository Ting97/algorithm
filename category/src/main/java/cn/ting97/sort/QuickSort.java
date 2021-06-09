package cn.ting97.sort;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className QuickSort
 * @Description 快速排序
 * @date 2021-06-09
 */
public class QuickSort {
    /**
     * 快速排序
     * 采用分治的思想
     * 稳定性： 不稳定
     * 复杂度： O(n^2)
     *
     * @param arr 数组
     */
    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    /**
     * 快排递归
     *
     * @param arr   数组
     * @param left  左下标
     * @param right 右下标
     */
    private static void qSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        qSort(arr, left, pivot - 1);
        qSort(arr, pivot + 1, right);
    }

    /**
     * 分割函数，以左下标的值为key，将大于key的值放右边，小于key的值放左边
     *
     * @param arr   数组
     * @param left  左下标
     * @param right 右下标
     * @return key下标
     */
    private static int partition(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                --right;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                ++left;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
}
