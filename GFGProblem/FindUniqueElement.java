package GFGProblem;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/problems/find-unique-element2632/1
public class FindUniqueElement {
    public static int findUnique(int a[], int n, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (freq.containsKey(a[i])) {
                freq.put(a[i], freq.get(a[i]) + 1);
            } else {
                freq.put(a[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() % k != 0) {
                return entry.getKey();
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(findUnique(new int[] { 6, 2, 5, 2, 2, 6, 6 }, 7, 3));
    }
}
