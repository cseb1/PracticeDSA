package Leetcodeproblem;

import java.util.Arrays;

// import java.util.Set;
// import java.util.TreeSet;

public class LeetCode150 {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
    /*
     * public static int removeDuplicates(int[] nums) {
     * // Set<Integer> s = new TreeSet<>();
     * // for (int it : nums) {
     * // s.add(it);
     * // }
     * // return s.size();
     * int j = 1;
     * for (int i = 1; i < nums.length; i++) {
     * if (nums[i] != nums[i - 1]) {
     * nums[j] = nums[i];
     * j++;
     * }
     * }
     * return j;
     * }
     */
    public static void reverse(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        // System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));
        rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
    }
}
