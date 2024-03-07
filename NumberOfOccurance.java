public class NumberOfOccurance {
    static int count = 0;

    public static long countOf3(int x) {
        // Write your code here.
        for (int i = 0; i <= x; i++) {
            helper(i);
        }
        return (long) count;
    }

    private static void helper(int i) {
        int no = i;
        if (no < 3) {
            return;
        }
        while (no > 0) {
            int rem = no % 10;
            if (rem == 3) {
                count++;
            }
            no = no / 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(countOf3(24));
    }
}
