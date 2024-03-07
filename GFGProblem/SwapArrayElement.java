package GFGProblem;

import java.util.Arrays;

public class SwapArrayElement {
    public static void swapElements(int[] arr, int n) {
        // Code here
        for (int i = 0; i < n - 2; i++) {
            int temp = arr[i];
            arr[i] = arr[i + 2];
            arr[i + 2] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        swapElements(new int[] { 1, 2, 3, 4, 5 }, 5);
    }
}
