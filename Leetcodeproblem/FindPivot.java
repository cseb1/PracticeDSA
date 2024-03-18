package Leetcodeproblem;

public class FindPivot {

    // lets try to math

    public static int pivotInteger(int n) {
        int y = n * (n + 1) / 2;
        int x = (int) Math.sqrt(y);
        if (x * x == y)
            return x;
        else
            return -1;

    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(1));
    }
}
