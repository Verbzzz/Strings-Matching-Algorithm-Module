package com.hit.algorithm;

import java.util.Arrays;
import java.util.Locale;

public class BoyerMoore implements IAlgoMatchingStrings {
    private static char[] text;
    private static char[] pattern;

    public BoyerMoore(){}
    public BoyerMoore (String txt,String pat) {
        String lowerTxt = txt.toLowerCase();
        String lowerPat = pat.toLowerCase();

        this.text = lowerTxt.toCharArray();
        this.pattern = lowerPat.toCharArray();
    }

    public char[] setTxt (String txt){
        String lowerTxt = txt.toLowerCase();
        return this.text = lowerTxt.toCharArray();
    }
    public char[] setPat (String pat){
        String lowerPat = pat.toLowerCase();
        return this.pattern = lowerPat.toCharArray();
    }

    public char[] getTxt(){
        return this.text;
    }
    public char[] getPat(){
        return this.pattern;
    }


    public static void main(String[] args) {

        BoyerMoore game = new BoyerMoore("Grand Theft Auto: San Andreas", "Grand Theft Auto");


        char txt[] = game.getTxt();
        char pat[] = game.getPat();

        int result = Search(txt, pat);
        System.out.println(result);
    }

    static int NO_OF_CHARS = 256;

    //A utility function to get maximum of two integers
    public static int max (int a, int b) { return (a > b)? a: b; }

    //The preprocessing function for Boyer Moore's
    //bad character heuristic
    public static void badCharHeuristic( char []str, int size,int badchar[])
    {

        // Initialize all occurrences as -1
        for (int i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;

        // Fill the actual value of last occurrence
        // of a character (indices of table are ascii and values are index of occurence)
        for (int i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }

    /* A pattern searching function that uses Bad
    Character Heuristic of Boyer Moore Algorithm */
    public static int Search( char txt[],  char pat[]) {
        if (txt.length < pat.length || pat[0] == ' ')  {
            System.out.println("Pattern is not valid");
            return -1;
        }
        else {

            int m = pat.length;
            int n = txt.length;

            int badchar[] = new int[NO_OF_CHARS];

      /* Fill the bad character array by calling
         the preprocessing function badCharHeuristic()
         for given pattern */
            badCharHeuristic(pat, m, badchar);

            int s = 0;  // s is shift of the pattern with
            // respect to text
            //there are n-m+1 potential allignments
            while (s <= (n - m)) {
                int j = m - 1;

          /* Keep reducing index j of pattern while
             characters of pattern and text are
             matching at this shift s */
                while (j >= 0 && pat[j] == txt[s + j])
                    j--;

          /* If the pattern is present at current
             shift, then index j will become -1 after
             the above loop */
                if (j < 0) {
                    //System.out.println("Found pattern at index = " + s);

              /* Shift the pattern so that the next
                 character in text aligns with the last
                 occurrence of it in pattern.
                 The condition s+m < n is necessary for
                 the case when pattern occurs at the end
                 of text */
                    //txt[s+m] is character after the pattern in text
                    s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
                    return 1;
                } else
              /* Shift the pattern so that the bad character
                 in text aligns with the last occurrence of
                 it in pattern. The max function is used to
                 make sure that we get a positive shift.
                 We may get a negative shift if the last
                 occurrence  of bad character in pattern
                 is on the right side of the current
                 character. */
                    s += max(1, j - badchar[txt[s + j]]);
            }
        }
        return 0;
    }
}