package Leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-falling-path-sum/description/?envType=daily-question&envId=2024-01-19
// dp pronlem== leetcode medium type problem
public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        // int r = matrix.length;
        int c = matrix[0].length;
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < c; i++) {
            ans = Math.min(ans, helper(0, i, matrix, hm));
        }
        return ans;
    }

    private static int helper(int i, int j, int[][] matrix, Map<String, Integer> hm) {
        int r = matrix.length;
        int c = matrix[0].length;
        if (i == r) {
            return 0;
        }
        if (j < 0 || j >= c) {
            return Integer.MAX_VALUE;
        }
        String key = i + "Susanta" + j;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        int op1 = helper(i + 1, j - 1, matrix, hm);
        int op2 = helper(i + 1, j, matrix, hm);
        int op3 = helper(i + 1, j + 1, matrix, hm);

        hm.put(key, matrix[i][j] + Math.min(op1, Math.min(op2, op3)));
        return matrix[i][j] + Math.min(op1, Math.min(op2, op3));
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } }));
    }
}