package GFGProblem;

//https://www.geeksforgeeks.org/problems/first-element-to-occur-k-times5150/1
import java.util.HashMap;
import java.util.Map;

public class FindFirstElement {
    public static int firstElementKTime(int n, int k, int[] a) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (freq.containsKey(a[i])) {
                freq.put(a[i], freq.get(a[i]) + 1);
            } else {
                freq.put(a[i], 1);
            }

            if (freq.get(a[i]) == k) {
                return a[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstElementKTime(7, 2, new int[] { 1, 7, 4, 3, 4, 8, 7 }));
    }
}
