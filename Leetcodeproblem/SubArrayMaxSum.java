package Leetcodeproblem;

public class SubArrayMaxSum {
    public int maxSubArray(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum > max_sum) {
                max_sum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {

    }
}
