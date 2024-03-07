public class MinimumRotatedArray {
    public static int findMin(int[] arr) {
        // Write your code here.
        int low = 0;
        int high = arr.length - 1;
        return binarySearch(arr, low, high);
    }

    private static int binarySearch(int[] arr, int low, int high) {
        // if array is rotated then the min element is te first element
        if (arr[low] <= arr[high]) {
            return arr[low];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[mid - 1]) { // if the middle element is sorted
                return arr[mid];
            }
            if (arr[mid] > arr[mid + 1])// left is sorted
            {
                low = mid + 1;
            } else {// right half is the sorted
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
    }
}
