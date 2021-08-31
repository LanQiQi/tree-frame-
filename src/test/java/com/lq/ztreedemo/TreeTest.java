package com.lq.ztreedemo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TreeTest {
    @Test
    public void test3(){
        HashMap hashMap = new HashMap();
        hashMap.put("a","aa");
        hashMap.put("b","bb");
        hashMap.put("a","cc");
        System.out.println(hashMap);
    }
}
