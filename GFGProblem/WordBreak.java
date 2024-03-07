package GFGProblem;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/word-break1352/1
public class WordBreak {
    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        if (helper(s, dictionary) == true) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean helper(String s, ArrayList<String> dictionary) {
        if (s.isEmpty()) {
            return true;
        }
        int wordlen = s.length();
        for (int i = 0; i < wordlen; i++) {
            String prefix = s.substring(0, i);

            if (dictionary.contains(prefix) && helper(s.substring(i), dictionary)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
