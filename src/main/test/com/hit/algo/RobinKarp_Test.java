package main.test.com.hit.algo;

import main.java.com.hit.algo.RobinKarp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobinKarp_Test {
    RobinKarp rk = new RobinKarp();
    int q = 101;
    int result;

    @Test
    public void longerPat (){
        rk.setPat("ABA");
        rk.setTxt("a");

        result = rk.Search(rk.getTxt(),rk.getPat(),q);
        assertEquals(-1,result,0);
    }
    @Test
    public void keySensitive(){
        rk.setPat("ABA");
        rk.setTxt("ababababa");
        result = rk.Search(rk.getTxt(),rk.getPat(),q);
        assertEquals(1,result,0);
    }

    @Test
    public void emptyPat(){
        rk.setPat(" ");
        rk.setTxt("abab ababa");
        result = rk.Search(rk.getTxt(),rk.getPat(),q);
        assertEquals(-1,result,0);
    }

    @Test
    public void patNotFound(){
        rk.setPat("dfgdgdf");
        rk.setTxt("lpoiliolio");
        result = rk.Search(rk.getTxt(),rk.getPat(),q);
        assertEquals(0,result,0);
    }
}
