package GFGProblem;

//https://www.geeksforgeeks.org/problems/difference-between-highest-and-lowest-occurrence4613/1
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DifferenceFirstandLastOcc {
    public static long findDiff(long arr[], long n) {
        HashMap<Long, Integer> a = new HashMap<>();
        for (int i = 0; i < n; i++)
            if (a.containsKey(arr[i])) {
                a.put(arr[i], a.get(arr[i]) + 1);
            } else {
                a.put(arr[i], 1);
            }
        Set<Long> b = new HashSet<>();
        for (int j = 0; j < n; j++) {
            b.add((long) a.get(arr[j]));
        }
        return Collections.max(b) - Collections.min(b);
    }

    public static void main(String[] args) {
        System.out.println(findDiff(new long[] {
                1, 2, 2
        }, 3));

        System.out.println(findDiff(new long[] { 7, 8, 4, 5, 4, 1, 1, 7, 7, 2, 5 }, 11));
    }
}
