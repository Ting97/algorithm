package cn.ting97.year2021.may.d15;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5742SortingTheSentence
 * @Description 将句子排序
 * @date 2021-05-16
 */
public class T5742SortingTheSentence {
    /**
     * 模拟
     *
     * @param s s
     * @return 答案
     */
    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        String[] ans = new String[strs.length];
        for (String str : strs) {
            int index = Integer.parseInt(String.valueOf(str.charAt(str.length() - 1)));
            StringBuilder st = new StringBuilder(str);
            st.deleteCharAt(st.length() - 1);
            ans[index - 1] = st.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : ans) {
            sb.append(str).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
