package Leetcodeproblem;

//https://leetcode.com/problems/custom-sort-string/description/
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public static String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char it : order.toCharArray()) {
            if (map.containsKey(it) == true) {
                result.append(String.valueOf(it).repeat(Math.max(0, map.get(it))));
                map.remove(it);
            }
        }
        for (char ch : map.keySet()) {
            result.append(String.valueOf(ch).repeat(Math.max(0, map.get(ch))));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }
}
