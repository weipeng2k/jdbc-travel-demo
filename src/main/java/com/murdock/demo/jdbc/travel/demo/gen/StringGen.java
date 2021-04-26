package com.murdock.demo.jdbc.travel.demo.gen;

/**
 * @author weipeng2k 2021年04月26日 下午17:43:41
 */
public interface StringGen {

    /**
     * 获取名称
     *
     * @param prefix 前缀
     * @return 名称
     */
    String gen(String prefix);

    /**
     * 在array中选一个
     * @param array 数组
     * @return name
     */
    String gen(String... array);
}
