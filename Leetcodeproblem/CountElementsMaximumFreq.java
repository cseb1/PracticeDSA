package Leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

public class CountElementsMaximumFreq {
    public static int maxFrequencyElements(int[] nums) {
        // take an unordered map
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) == true) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            max = Math.max(max, map.get(nums[i]));
        }
        int cnt = 0;
        for (Integer entry : map.keySet()) {
            if (map.get(entry) == max) {
                cnt++;
            }
        }
        return (cnt * max);
    }

    public static void main(String[] args) {
        int ans = maxFrequencyElements(new int[] { 1, 2, 2, 3, 1, 4 });
        System.out.println(ans);
        System.out.println(maxFrequencyElements(new int[] { 1, 2, 3, 4, 5 }));
    }
}
