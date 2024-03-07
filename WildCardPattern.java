import java.util.Scanner;

public class WildCardPattern {
    // https://www.codingninjas.com/studio/problem-of-the-day/hard?leftPanelTabValue=PROBLEM
    public static boolean wildcardMatching(String pattern, String text) {
        // Write your code here
        String p = pattern;
        String s = text;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Pattern:: ");
            String pattern = scanner.nextLine();

            System.out.println("Enter The Text:::");
            String text = scanner.nextLine();

            System.out.println("Is It Matching?:::" + wildcardMatching(pattern, text));
        }
    }
}
