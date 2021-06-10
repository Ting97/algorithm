package cn.ting97.sort;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className HeapSort
 * @Description 堆排序
 * @date 2021-06-09
 */
public class HeapSort {

    private int[] heap;

    public HeapSort(int[] arr) {
        heap = arr;
    }

    private int getParentIndex(int index) {
        return (index - 1) >> 1;
    }

    private int getLeftChildrenIndex(int index) {
        return (index << 1) + 1;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 调整推
     *
     * @param i   当前位置
     * @param len 堆长度
     */
    private void adjustHeap(int i, int len) {
        int left, right, j;
        left = getLeftChildrenIndex(i);
        while (left <= len) {
            right = left + 1;
            j = left;
            if (j < len && heap[left] < heap[right]) {
                j++;
            }
            if (heap[i] < heap[j]) {
                swap(i, j);
                i = j;
                left = getLeftChildrenIndex(i);
            } else {
                break;
            }
        }
    }

    /**
     * 堆排序
     */
    public void sort() {
        int last = heap.length - 1;
        // 初始化最大堆
        for (int i = getParentIndex(last); i >= 0; --i) {
            adjustHeap(i, last);
        }
        // 堆调整
        while (last >= 0) {
            swap(0, last--);
            adjustHeap(0, last);
        }
    }

}
