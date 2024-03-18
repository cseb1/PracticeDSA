package CodeStudio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicate {
    public static int findDuplicate(ArrayList<Integer> arr) {

        // Write your code here.
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (map.containsKey(arr.get(i)) == true) {
                map.put(arr.get(i), map.get(arr.get(i)) + 1);
            } else {
                map.put(arr.get(i), 1);
            }
        }
        for (Integer it : map.keySet()) {
            if (map.get(it) == 2) {
                ans = it;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println("Duplicate element is ="+findDuplicate(arr));
    }
}
