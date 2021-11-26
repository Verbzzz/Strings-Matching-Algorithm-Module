package com.hit.algorithm;

import com.hit.algorithm.IAlgoMatchingStrings;

import java.util.Locale;

public class RobinKarp implements IAlgoMatchingStrings {
    private static String text;
    private static String pattern;

    public RobinKarp() { }

    public RobinKarp (String txt, String pat) {
        this.text = txt.toLowerCase();
        this.pattern = pat.toLowerCase(Locale.ROOT);
    }

    public String setTxt (String txt){
        return this.text = txt.toLowerCase();
    }
    public String setPat (String pat){
        return this.pattern = pat.toLowerCase();
    }

    public String getTxt(){
        return this.text;
    }
    public String getPat(){
        return this.pattern;
    }

    public static void main(String[] args) {
        int q = 101; // A prime number

        RobinKarp game = new RobinKarp("Grand Theft Auto: San Andreas", "Grand Theft");

        String txt = game.getTxt();
        String pat = game.getPat();

        int result = Search(txt, pat, q);
        System.out.println(result);
    }

    // d is the number of characters in the input alphabet
    public final static int d = 256;

     static int Search(String txt, String pat, int q)
    {
        if(txt.length() < pat.length() || pat == " ") {
        System.out.println("Pattern is not valid");
        return -1;
        }
        else {
            int M = pat.length();
            int N = txt.length();
            int i, j;
            int p = 0; // hash value for pattern
            int t = 0; // hash value for txt
            int h = 1;

            // The value of h would be "pow(d, M-1)%q"
            for (i = 0; i < M - 1; i++)
                h = (h * d) % q;

            // Calculate the hash value of pattern and first
            // window of text
            for (i = 0; i < M; i++) {
                p = (d * p + pat.charAt(i)) % q;
                t = (d * t + txt.charAt(i)) % q;
            }

            // Slide the pattern over text one by one
            for (i = 0; i <= N - M; i++) {

                // Check the hash values of current window of text
                // and pattern. If the hash values match then only
                // check for characters on by one
                if (p == t) {
                    /* Check for characters one by one */
                    for (j = 0; j < M; j++) {
                        if (txt.charAt(i + j) != pat.charAt(j))
                            break;
                    }

                    // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                    if (j == M)
                        //System.out.println("Pattern found at index " + i);
                        return 1;
                }

                // Calculate hash value for next window of text: Remove
                // leading digit, add trailing digit
                if (i < N - M) {
                    t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

                    // We might get negative value of t, converting it
                    // to positive
                    if (t < 0)
                        t = (t + q);
                }
            }
        }
        return 0;
    }
}