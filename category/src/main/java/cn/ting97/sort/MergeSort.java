package cn.ting97.sort;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className MergeSort
 * @Description 归并排序
 * @date 2021-06-09
 */
public class MergeSort {
    /**
     * 归并排序
     * 使用分治的思想，在数据量较大的情况下也有较好的表现，空间复杂度O(n)，数据量较大的时候几乎不可接受
     * 稳定性：稳定
     * 复杂度：O(nlogn)
     *
     * @param arr 数组
     */
    public static void mergeSort(int[] arr) {
        int length = arr.length;
        int[] temp = new int[length];
        mergeSort(arr, temp, 0, length - 1);
    }

    /**
     * 递归归并
     * @param arr 数组
     * @param temp 临时数组
     * @param left 起始下标
     * @param right 结束下标
     */
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) >> 1;
            // 左归并
            mergeSort(arr, temp, left, mid);
            // 右归并
            mergeSort(arr, temp, mid + 1, right);
            // 归并
            merge(arr, temp, left, mid, right);
        }
    }

    /**
     * 合并方法
     * @param arr 数组
     * @param temp 临时数组
     * @param left 起始下标
     * @param mid 中间下标
     * @param right 结束下标
     */
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = left; i <= right; ++i) {
            arr[i] = temp[i];
        }
    }
}
