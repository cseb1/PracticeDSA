import java.util.Arrays;

public class Patternify {
    public static String[] printPatt(int n) {
        String[] ans = new String[n];
        Arrays.fill(ans, "");
        for (int i = 0; i < n; i++) {
            int temp = (n - i);
            for (int j = 0; j < temp; j++) {
                ans[i] += "*";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printPatt(5)));
    }
}
