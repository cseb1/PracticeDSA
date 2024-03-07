package GFGProblem;

//https://www.geeksforgeeks.org/problems/peak-element/1
public class PeakElement {
    public static int peakElement(int[] arr, int n) {
        // Expected time complexity is =O(log(n))
        // So we can realize that it is one of the Binary search problem

        // we can take two variable low and high
        int low = 0;
        int high = n - 1;

        while (low < high) {
            // find middle position
            int mid = low + (high - low) / 2;
            if (arr[mid] >= arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /*
     * this is code studio problem
     * public static int findPeakElement(ArrayList<Integer> arr) {
     * // Write your code here.
     * int low = 0;
     * int high = n - 1;
     * 
     * while (low < high) {
     * // find middle position
     * int mid = low + (high - low) / 2;
     * if (arr.get(mid)>= arr.get(mid+1)) {
     * high = mid;
     * } else {
     * low = mid + 1;
     * }
     * }
     * return low;
     * }
     */

    public static void main(String[] args) {
        System.out.println(peakElement(new int[] { 1, 2, 3 }, 3));
        System.out.println(peakElement(new int[] { 1, 1, 1, 2, 1, 1, 1 }, 7));
    }
}
