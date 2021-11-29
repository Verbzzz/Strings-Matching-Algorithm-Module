package main.test.com.hit.algo;

import main.java.com.hit.algo.KMP;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Kmp_Test {
    KMP kmp = new KMP();
    int result;

    @Test
    public void longerPat (){
        kmp.setPat("ABA");
        kmp.setTxt("a");

        result = kmp.Search(kmp.getTxt(),kmp.getPat());
        assertEquals(-1,result,0);
    }

    @Test
    public void keySensitive(){
        kmp.setPat("ABA");
        kmp.setTxt("ababababa");
        result = kmp.Search(kmp.getTxt(),kmp.getPat());
        assertEquals(1,result,0);
    }

    @Test
    public void emptyPat(){
        kmp.setPat(" ");
        kmp.setTxt("abab ababa");
        result = kmp.Search(kmp.getTxt(),kmp.getPat());
        assertEquals(-1,result,0);
    }

    @Test
    public void patNotFound(){
        kmp.setPat("dfgdgdf");
        kmp.setTxt("lpoiliolio");
        result = kmp.Search(kmp.getTxt(),kmp.getPat());
        assertEquals(0,result,0);
    }
}
