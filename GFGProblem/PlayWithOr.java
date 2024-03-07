package GFGProblem;

import java.util.Arrays;

public class PlayWithOr {
    public static int[] game_with_number(int arr[], int n) {
        // Complete the function
        for (int i = 0; i < n - 1; i++) {
            arr[i] = (arr[i] | arr[i + 1]);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(game_with_number(new int[] { 10, 11, 1, 2, 3 }, 5)));
    }
}
