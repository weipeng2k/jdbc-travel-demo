package com.murdock.demo.jdbc.travel.demo.gen.impl;

import com.murdock.demo.jdbc.travel.demo.gen.IntGen;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author weipeng2k 2021年04月26日 下午17:48:21
 */
@Component("intGen")
public class IntGenImpl implements IntGen {

    @Override
    public int gen(int startInclude, int endExclude) {
        int delta = endExclude - startInclude;
        Random random = new Random();
        int i = random.nextInt(delta);
        return startInclude + i;
    }
}
