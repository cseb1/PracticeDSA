package GFGProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class EulerianPath {

    public static boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        for (ArrayList<Integer> al : adj) {
            if (al.size() % 2 != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the no of vertices:");
            int v = scanner.nextInt();
            System.out.println("Enter the no of edges:");
            int e = scanner.nextInt();
            for (int i = 0; i < e; i++) {
                input = new ArrayList<>();
            }
            ArrayList<Integer> temp;
            for (int i = 0; i < e; i++) {
                temp = new ArrayList<>();
                System.out.println("enter the src and dest:");
                int src = scanner.nextInt();
                int dst = scanner.nextInt();
                temp.add(src);
                temp.add(dst);
                input.add(temp);
            }
            System.out.println(input);
            System.out.println(isEularCircuitExist(v, input));
        }

    }
}
