public class ContainerWater {
    // https://www.geeksforgeeks.org/problems/container-with-most-water0535/1
    public static int maxArea(int[] height) {
        // Write your code here.
        int maximumWater = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int lh = height[l];
            int rh = height[r];
            int min_h = Math.min(lh, rh);
            maximumWater = Math.max(maximumWater, min_h * (r - l));
            if (lh < rh)
                l++;
            else
                r--;
        }
        return maximumWater;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 2, 1 }));
    }
}
