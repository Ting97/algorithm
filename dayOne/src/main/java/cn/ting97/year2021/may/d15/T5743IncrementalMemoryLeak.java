package cn.ting97.year2021.may.d15;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T5743IncrementalMemoryLeak
 * @Description 增长的内存泄露
 * @date 2021-05-16
 */
public class T5743IncrementalMemoryLeak {
    /**
     * 模拟
     *
     * @param memory1 内存1
     * @param memory2 内存2
     * @return 结果
     */
    public int[] memLeak(int memory1, int memory2) {
        int ansTimes = 1;
        for (; ansTimes <= Math.max(memory1, memory2); ++ansTimes) {
            if (memory1 >= memory2) {
                memory1 -= ansTimes;
            } else {
                memory2 -= ansTimes;
            }
        }
        return new int[]{ansTimes, memory1, memory2};
    }
}
