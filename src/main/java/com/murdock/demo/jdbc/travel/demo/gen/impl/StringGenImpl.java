package com.murdock.demo.jdbc.travel.demo.gen.impl;

import com.murdock.demo.jdbc.travel.demo.gen.StringGen;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author weipeng2k 2021年04月26日 下午17:44:37
 */
@Component("stringGen")
public class StringGenImpl implements StringGen {

    @Override
    public String gen(String prefix) {
        Random random = new Random();
        return prefix + random.nextInt();
    }

    @Override
    public String gen(String... array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
}
