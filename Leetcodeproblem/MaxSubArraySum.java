package Leetcodeproblem;

import java.util.Arrays;

public class MaxSubArraySum {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        // do memorization
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return f(0, arr, k, dp);
    }

    private static int f(int idx, int[] arr, int k, int[] dp) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int len = 0;
        // base
        if (idx == n) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        for (int j = idx; j < Math.min(idx + k, n); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int Sum = maxi * len + f(j + 1, arr, k, dp);
            maxSum = Math.max(maxSum, Sum);
        }
        return dp[idx] = maxSum;
    }

    public static void main(String[] args) {

        System.out.println(maxSumAfterPartitioning(new int[] { 1, 15, 7, 9, 2, 5, 10 }, 3));
    }
}
