package CodeStudio;

/*
	Time complexity: O(M*N)
	Space complexity: O(1)
	
	Where 'M' and 'N' are the dimensions of the matrix.
*/

import java.util.HashSet;

public class MagicSquares {

    private static boolean isValid(int[][] mat, int m, int n, int i, int j) {
        // Base case.
        if (m - i < 3 || n - j < 3) {
            return false;
        }

        // To store distinct numbers.
        HashSet<Integer> val = new HashSet<>();

        // Traverse the subMatrix.
        for (int r = i; r < i + 3; ++r) {
            for (int c = j; c < j + 3; ++c) {
                val.add(mat[r][c]);
            }
        }

        // Check if all distinct numbers are present in submatrix.
        if (val.size() != 9) {
            return false;
        }

        // First row sum.
        int row1 = mat[i][j] + mat[i][j + 1] + mat[i][j + 2];

        // Second row sum.
        int row2 = mat[i + 1][j] + mat[i + 1][j + 1] + mat[i + 1][j + 2];

        // Third row sum.
        int row3 = mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2];

        // Check for sum of all rows.
        if ((row1 != row2) || (row1 != row3)) {
            return false;
        }

        // Check for columns.
        int col1 = mat[i][j] + mat[i + 1][j] + mat[i + 2][j];
        int col2 = mat[i][j + 1] + mat[i + 1][j + 1] + mat[i + 2][j + 1];
        int col3 = mat[i][j + 2] + mat[i + 1][j + 2] + mat[i + 2][j + 2];

        // Check for sum of all columns.
        if ((col1 != col2) || (col1 != col3) || (row1 != col1)) {
            return false;
        }

        // Check for diagonals.
        int diag1 = mat[i][j] + mat[i + 1][j + 1] + mat[i + 2][j + 2];
        int diag2 = mat[i][j + 2] + mat[i + 1][j + 1] + mat[i + 2][j];

        // Check for sum of all diagonals.
        if ((diag1 != diag2) || (row1 != diag1)) {
            return false;
        }

        return true;
    }

    public static int countSqaures(int m, int n, int[][] mat) {

        // Base case.
        if (m < 3 || n < 3) {
            return 0;
        }

        // To store the result.
        int cnt = 0;

        // Traverse the matrix.
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {

                // Check if valid matrix.
                if (isValid(mat, m, n, i, j)) {

                    // Increment count.
                    ++cnt;
                }
            }
        }

        return cnt;
    }

    public static long minimumCost(int[] cost, int n, int k) {
        // Write your code here.
        int result = 0;
        for (int i = 0; i < n; i++) {
            // Buy current candy
            result += cost[i];
            // And take k candies for free from the last
            n = n - k;
        }
        return result;
    }

    // Function to calculate maximum cost.
    public static long maximumCost(int[] cost, int n, int k) {
        // Write your code here.
        int result = 0;
        int index = 0;

        for (int i = n - 1; i >= index; i--) {
            // Buy candy with maximum amount
            result += cost[i];

            // And get k candies for free from the starting
            index += k;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
