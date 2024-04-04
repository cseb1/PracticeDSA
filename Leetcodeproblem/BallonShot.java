package Leetcodeproblem;

//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
import java.util.Arrays;

public class BallonShot {
    public static int findMinArrowShots(int[][] points) {
        int arrow = 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int last = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > last) {
                arrow++;
                last = points[i][1];
            } else {
                last = Math.min(last, points[i][1]);
            }
        }
        return arrow;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }));
    }
}
