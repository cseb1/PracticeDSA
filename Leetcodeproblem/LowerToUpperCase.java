package Leetcodeproblem;

public class LowerToUpperCase {
    public static String convertString(String str) {
        // Write your code here
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1));
            if (i != words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertString("i am a third year student"));
    }
}
