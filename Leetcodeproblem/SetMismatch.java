package Leetcodeproblem;

import java.util.Arrays;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        while (i < n) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        int ans[] = new int[2];
        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j] - 1) {
                ans[0] = nums[j];
                ans[1] = j + 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[] { 3, 2, 2 })));
    }
}
