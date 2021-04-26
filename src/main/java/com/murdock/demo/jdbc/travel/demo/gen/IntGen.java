package com.murdock.demo.jdbc.travel.demo.gen;

/**
 * @author weipeng2k 2021年04月26日 下午17:46:52
 */
public interface IntGen {

    /**
     * <pre>
     * 在start和end之间随机一个
     *
     * [0, 4)，在0，1，2，3之间选一个
     * [3, 10)，在3,4,5,6,7,8,9之间选一个
     * </pre>
     *
     * @param startInclude [
     * @param endExclude   )
     * @return 值
     */
    int gen(int startInclude, int endExclude);
}
