package Leetcodeproblem;

public class FirstPalindromic {
    public static String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (check(words[i], 0, words[i].length() - 1) == true) {
                return words[i];
            }
        }
        return " ";
    }

    private static boolean check(String string, int lb, int up) {
        while (lb < up) {
            if (string.charAt(lb) == string.charAt(up)) {
                lb++;
                up--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[] { "abc", "car", "ada", "racecar", "cool" }));
    }
}
