package Leetcodeproblem;

import java.util.Arrays;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresArray {
    public static int[] sortedSquares(int[] nums) { // time complexity is O(n).sorting operation TC
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }

    // Now our question is can you solve it by O(n) time.
    // Yes, I can do it by O(n) time using two pointers method

    public static int[] sortedArray(int[] nums) {
        // declared an array which is stored the answer
        int[] ans = new int[nums.length];
        // Initialized the left and right variable .
        int left = 0;
        int right = nums.length - 1;
        int sq = 0;
        int i = nums.length - 1;
        while (left <= right) {
            // check whether the left index value is higher of the rigt index
            // if true, then the right index square value is stored the last index
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                sq = nums[left];
                left++;
            } else {
                sq = nums[right];
                right--;
            }
            ans[i--] = sq * sq;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedArray(new int[] { -4, -1, 0, 3, 10 })));
    }
}
