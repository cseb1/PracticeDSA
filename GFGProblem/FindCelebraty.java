package GFGProblem;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
public class FindCelebraty {
    public static int celebrity(int M[][], int n) {
        int[] inout = new int[n];
        Arrays.fill(inout, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    inout[i]--;// outdegree
                    inout[j]++; // indegree
                }
            }
        }
        // System.out.println(Arrays.toString(inout));
        for (int i = 0; i < n; i++) {
            if (inout[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(celebrity(new int[][] { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } }, 3));
    }
}
