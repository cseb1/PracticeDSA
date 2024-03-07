package Leetcodeproblem;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : nums) {
            if (map.containsKey(it) == true) {
                map.put(it, map.get(it) + 1);
            } else {
                map.put(it, 1);
            }
        }
        // System.out.println(map);
        int checking_period = nums.length / 2;
        for (int it : map.keySet()) {
            if (map.get(it) > checking_period) {
                ans = it;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 3, 2, 3 }));
    }
}
