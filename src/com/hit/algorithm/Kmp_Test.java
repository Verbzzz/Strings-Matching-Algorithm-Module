package com.hit.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Kmp_Test {
    KMP kmp = new KMP();

    @Test
    public void test (){
        kmp.setPat("ABA");
        kmp.setTxt("a");

        int result = kmp.Search(kmp.getPat(),kmp.getTxt());
        assertEquals(-1,result,0);

        kmp.setPat("ABA");
        kmp.setTxt("fdshgds dahdas aba fhsdfhds");
        result = kmp.Search(kmp.getPat(),kmp.getTxt());
        assertEquals(1,result,0);


    }
}
