package Leetcodeproblem;

//https://leetcode.com/problems/maximum-odd-binary-number/description/?envType=daily-question&envId=2024-03-01
public class MaximumOddBinatyNumber {
    public static String maximumOddBinaryNumber(String s) {
        // declaration the ans variable.
        // we can also use StringBuilder class
        String ans = "";
        // Initialized the two variable countOne and countZero
        int countOne = 0;
        int countZero = 0;
        // store the no of 1 and 0 present in the given string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOne++;
            } else {
                countZero++;
            }
        }
        // add the 1's in the begining except one 1's
        while (countOne > 1) {
            ans += '1';
            countOne--;
        }
        // add all the 0's in the middle
        while (countZero >= 1) {
            ans += '0';
            countZero--;
        }
        // add 1's in the last position
        ans += '1';
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("0101"));
        System.out.println(maximumOddBinaryNumber("010"));
    }
}
