package Leetcodeproblem;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-town-judge/description/
public class FindTownGudge {
    public static int findJudge(int n, int[][] trust) {
        // we obtained an array which are store to calculating indegree and outdgree of
        // any pair of trust
        // And our ultimate goal is to find (indegree-outdegree)==n-1.
        // return this index.
        // base case
        if (n == 1) {
            return 1;
        }
        int[] inout = new int[n + 1];
        Arrays.fill(inout, 0);
        for (int[] x : trust) {
            inout[x[0]]--;
            inout[x[1]]++;
        }

        // checking purpose
        // System.out.println(Arrays.toString(inout));
        for (int i = 0; i < inout.length; i++) {
            if (inout[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][] { { 1, 2 } }));
        System.out.println(findJudge(1, new int[][] {}));
    }
}
