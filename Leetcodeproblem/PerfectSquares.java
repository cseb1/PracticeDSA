package Leetcodeproblem;

//https://leetcode.com/problems/perfect-squares/?envType=daily-question&envId=2024-02-08
import java.util.Arrays;

public class PerfectSquares {
    public static int numSquares(int n) {
        int[] dp = new int[(int) 1e4];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
    // simple using recursion could effect TLE for large test cases
    // so I used to DP for memorization

    private static int solve(int n, int[] dp) {
        // base condition
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int squsum = i * i;
            int count = 1 + solve(n - squsum, dp);
            ans = Math.min(ans, count);
        }
        return dp[n] = ans;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
