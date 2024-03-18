package Leetcodeproblem;

//https://leetcode.com/problems/intersection-of-two-arrays/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        // we can solve this problem instead of use hashMap by using Set Data Structure.
        int n = nums1.length;
        ArrayList<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = nums1[i];
            if (map.containsKey(curr) == true) {
                map.put(curr, map.get(curr) + 1);
            } else {
                map.put(curr, 1);
            }
        }
        for (int it : nums2) {
            if (map.containsKey(it) == true) {
                arr.add(it);
                map.remove(it);
            }
        }
        int k = 0;
        int[] ans = new int[arr.size()];
        for (Integer it : arr) {
            ans[k++] = it;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
        System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
    }
}
