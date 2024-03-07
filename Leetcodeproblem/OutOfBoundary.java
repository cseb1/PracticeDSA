package Leetcodeproblem;

public class OutOfBoundary {

    // smple recursion approach
    // public static int findPaths(int m, int n, int maxMove, int startRow, int
    // startColumn) {
    // return helper(m, n, maxMove, startRow, startColumn);
    // }

    // private static int helper(int m, int n, int k, int row, int col) {
    // if (row < 0 || row == m || col < 0 || col == n) {
    // return 1;
    // }
    // if (k == 0) {
    // return 0;
    // }

    // int res1 = helper(m, n, k - 1, row - 1, col);
    // int res2 = helper(m, n, k - 1, row + 1, col);
    // int res3 = helper(m, n, k - 1, row, col + 1);
    // int res4 = helper(m, n, k - 1, row, col - 1);

    // return (res1 + res2 + res3 + res4);
    // }
    // let memorized this or optimized this
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[maxMove + 1][m][n];
        return helper(m, n, maxMove, startRow, startColumn, dp);

    }

    private static final int kMod = 1_000_000_007;

    private static int helper(int m, int n, int k, int row, int col, Integer[][][] dp) {
        if (row < 0 || row == m || col < 0 || col == n) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[k][row][col] != null) {
            return dp[k][row][col];
        }
        return dp[k][row][col] = (int) ((helper(m, n, k - 1, row + 1, col, dp) * 1L +
                helper(m, n, k - 1, row - 1, col, dp) +
                helper(m, n, k - 1, row, col + 1, dp) +
                helper(m, n, k - 1, row, col - 1, dp)) %
                kMod);
    }

    public static void main(String[] args) {
        System.out.println(findPaths(2, 2, 2, 0, 0));
    }
}
