package GFGProblem;

// import java.util.ArrayList;
// import java.util.List;

public class SumOfAllSubString {

    public static long sumSubstrings(String s) {
        long mod = (long) 1e9 + 7;
        long m = 1;
        long ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            long d = s.charAt(i) - '0';
            long sum = (i + 1) * m * d;
            ans += sum;
            m *= 10;
            m++;
            m %= mod;
            ans %= mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sumSubstrings("1234"));
    }

}