package GFGProblem;

import java.util.ArrayList;

public class KarpRabin {
    private static final int PRIME = 101;

    private static double calculateHash(String str) {
        double hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private static double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
        double newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    static ArrayList<Integer> search(String pattern, String text) {
        ArrayList<Integer> ans = new ArrayList<>();
        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLength));

        for (int i = 0; i <= text.length() - patternLength; i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    // System.out.println("Pattern found at index " + i);
                    ans.add(i + 1);
                }
            }

            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String text = "birthdayboy";
        String pattern = "birth";

        System.err.println(search(pattern, text));

        String text1 = "geeksforgeeks";
        String pattern1 = "geek";
        System.out.println(search(pattern1, text1));
    }
}
