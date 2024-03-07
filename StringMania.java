public class StringMania {
    public static int stringMania(int n, int m, String str1, String str2) {
        // Write your code here.
        int ans = 0;
        for (int i = 0; i < Math.min(n, m); i++) {
            for (int j = 0; j < i; j++) {
                if (str1.charAt(j) == str2.charAt(j) && str1.charAt(i) != str2.charAt(i)) {
                    if (str1.charAt(i) - 'a' > str2.charAt(i) - 'a') {
                        return 1;
                    } else if (str1.charAt(i) - 'a' > str2.charAt(i) - 'a') {
                        return -1;
                    }
                }
            }
        }
        if (n > m) {
            ans = 1;
        } else if (n < m) {
            ans = -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(stringMania(1, 3, "a", "abc"));
        System.out.println(stringMania(3, 3, "abc", "abz"));
    }
}
