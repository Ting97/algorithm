package cn.ting97.year2021.may.d12;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T557ReverseWordsInAStringIII
 * @Description 反转字符串中的单词 III
 * @date 2021-05-12
 */
public class T557ReverseWordsInAStringIII {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * @param s 字符串
     * @return 翻转后
     */
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int start = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == ' ') {
                revers(array, start, i - 1);
                start = i + 1;
            } else if (i == array.length - 1) {
                revers(array, start, i);
            }
        }
        return new String(array);
    }

    /**
     * 翻转
     *
     * @param arr   字符串组
     * @param start 起始位置
     * @param end   终点位置
     */
    private void revers(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    /**
     * 翻转
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
