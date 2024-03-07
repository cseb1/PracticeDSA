package Leetcodeproblem;

import java.util.ArrayList;
import java.util.Collections;

public class GlowingBulb {
    static ArrayList<Long> bulbs = new ArrayList<>();

    public static long findKthGlowingBulb(ArrayList<Integer> labels, long k) {

        // Write your code here
        int n = labels.size();
        for (int j = 0; j < n; j++) {
            int curr = labels.get((int) j);
            System.out.println(curr);
            ArrayList<Long> list = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                list.add((long) (curr * i));
            }
            sort(list);
        }
        System.out.println(bulbs);
        return bulbs.get((int) k);
    }

    private static void sort(ArrayList<Long> list) {

        bulbs.addAll(list);
        Collections.sort(bulbs);

    }

    public static void main(String[] args) {
        ArrayList<Integer> labels = new ArrayList<>();
        labels.add(3);
        labels.add(5);
        labels.add(7);
        System.out.println(findKthGlowingBulb(labels, 5));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        System.out.println(findKthGlowingBulb(list, 5));
    }
}
