package CodeStudio;

public class CountOfPlates {
    public static boolean countPlatesOnTable(int n, int R, int r) {
        // Write your code here
        if (n == 0) {
            return true;
        }

        if (n == 1) {
            return r <= R;
        }

        if (n == 2) {
            return r * 2 <= R;
        }

        double rho = r * (1 + Math.sqrt(2));
        if (rho <= R) {
            return r <= (R - r) / 2;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(countPlatesOnTable(4, 10, 4));
    }
}
