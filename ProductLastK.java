import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductLastK {
    static List<Integer> arr;

    public static int[] solve(int q, int[][] queries) {
        // Write your code here

        arr = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int choice = queries[i][0];
            if (choice == 0) {
                // insert operation;
                arr.add(queries[i][0]);
            } else if (choice == 1) {
                // product operation
                ans.add(lastKDigits(queries[i][1]));
            }

        }
        int[] s = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            s[i] = ans.get(i);
        }
        return s;
    }

    static int lastKDigits(int k) {
        int n = arr.size();
        if (n < k) {
            return 0;
        }
        int res = 0;
        for (int i = arr.size() - 1; i >= n - k; i--) {
            res *= arr.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays
                .toString(solve(10, new int[][] { { 0, 3 }, { 0, 0 }, { 0, 2 }, { 0, 5 }, { 0, 4 }, { 1, 2 }, { 1, 3 },
                        { 1, 4 }, { 0, 8 }, { 1, 2 } })));
    }
}
