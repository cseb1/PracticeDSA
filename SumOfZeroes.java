import java.util.ArrayList;
import java.util.Scanner;

//https://www.codingninjas.com/studio/problem-of-the-day/easy?leftPanelTabValue=PROBLEM
public class SumOfZeroes {
    public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {

        // Write your code here.
        int[][] matrix = new int[mat.size()][mat.get(0).size()];
        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.get(i).size(); j++) {
                matrix[i][j] = mat.get(i).get(j);
            }
        }
        return getTotalCoverageOfMatrix(matrix);
    }

    private static int getTotalCoverageOfMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    int count = 0;
                    if (i > 0 && matrix[i - 1][j] == 1) {
                        count++;
                    }
                    if (i < rows - 1 && matrix[i + 1][j] == 1) {
                        count++;
                    }
                    if (j > 0 && matrix[i][j - 1] == 1) {
                        count++;
                    }
                    if (j < cols - 1 && matrix[i][j + 1] == 1) {
                        count++;
                    }
                    sum += count;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the row--> ");
            int row = scanner.nextInt();
            System.out.println("Enter the coloumn --> ");
            int col = scanner.nextInt();
            for (int i = 0; i < row; i++) {
                System.out.println("enter the " + i + "th row value");
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < col; j++) {
                    list.add(scanner.nextInt());
                }
                matrix.add(list);
            }
        }
        System.out.println("Ans==" + coverageOfMatrix(matrix));

    }
}
