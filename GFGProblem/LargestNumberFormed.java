package GFGProblem;

//https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormed {
    static String printLargest(int n, String[] arr) {
        // code here
        // But this code gives Runtime error for big input so we can improve this code
        // below
        // the next methods;
        String ans = "";
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {

                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;

                // Now see which of the two
                // formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            ans += arr[i];
        }
        return ans;
    }

    public static String ans(int n, String[] arr) { // this code is an efficient approach
        Comparator<String> custom = (String a, String b) -> {
            return (b + a).compareTo(a + b);
        };
        String ans = "";
        Arrays.sort(arr, custom);
        for (String s : arr) {
            ans += s;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(ans(5, new String[] { "3", "30", "34", "5", "9" }));
    }
}
