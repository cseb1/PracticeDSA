package Leetcodeproblem;

import java.util.Arrays;

//https://leetcode.com/problems/bag-of-tokens/description/
public class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int maxScore = 0;
        int l = 0;
        int r = tokens.length - 1;
        // sort the array
        Arrays.sort(tokens);
        while (l <= r) {
            // 1. Face up operation
            if (power >= tokens[l]) {
                power -= tokens[l++];
                score++;
                maxScore = Math.max(score, maxScore);
            }

            // 2. face down operation
            else if (score > 0) {
                power += tokens[r--];
                score--;
            } else {
                break;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[] { 100, 400, 300, 200 }, 200));
    }
}
