package main.java.com.hit.algo;

public class KMP implements IAlgoMatchingStrings {
    private static String text;
    private static String pattern;

    public KMP (String txt, String pat) {
        this.text = txt.toLowerCase();
        this.pattern = pat.toLowerCase();

    }
    public KMP(){}
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

        KMP game = new KMP("Grand Theft Auto:San Andreas", "Grand Theft Auto");
        String txt = game.getTxt();
        String pat = game.getPat();
        int result = Search(txt, pat);
        System.out.println(result);
    }

    public static int Search(String txt, String pat) {
        if(txt.length() < pat.length() || pat == " ") {
            System.out.println("Pattern is not valid");
            return -1;
        }
        else {
            int M = pat.length();
            int N = txt.length();
            int lps[] = new int[M];
            int j = 0;

            computeLPSArray(pat, M, lps);

            int i = 0; // index for txt[]
            while (i < N) {
                if (pat.charAt(j) == txt.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == M) {
                   // System.out.println("Found pattern " + "at index " + (i - j));
                    j = lps[j - 1];
                    return 1;
                }

                // mismatch after j matches
                else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                    // Do not match lps[0..lps[j-1]] characters,
                    // they will match anyway
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i = i + 1;
                }
            }
        }
        return 0;
    }

    public static void computeLPSArray (String pat,int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}


