package Leetcodeproblem;

import java.util.Arrays;

//https://leetcode.com/problems/missing-number/description/?envType=daily-question&envId=2024-02-20
public class MissingNumber {
    // Naive approach
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    // best approach
    public static int missing(int nums[]) {
        int n = nums.length;
        int total = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return total - sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 3, 0, 1 }));
        System.out.println(missingNumber(new int[] { 0, 1 }));
    }
}
