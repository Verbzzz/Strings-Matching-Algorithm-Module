package com.hit.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoyerMoore_Test {
    BoyerMoore bm = new BoyerMoore();

    @Test
    public void longerPat (){
        bm.setPat("ABA");
        bm.setTxt("a");

        int result = bm.Search(bm.getTxt(),bm.getPat());
        assertEquals(-1,result,0);
    }
    @Test
    public void keySensitive(){
        bm.setPat("ABA");
        bm.setTxt("ababababa");
        int result = bm.Search(bm.getTxt(),bm.getPat());
        assertEquals(1,result,0);
    }

    @Test
    public void emptyPat(){
        bm.setPat(" ");
        bm.setTxt("abab ababa");
        int result = bm.Search(bm.getTxt(),bm.getPat());
        assertEquals(-1,result,0);
    }

    @Test
    public void patNotFound(){
        bm.setPat("dfgdgdf");
        bm.setTxt("lpoiliolio");
        int result = bm.Search(bm.getTxt(),bm.getPat());
        assertEquals(0,result,0);
    }
}
