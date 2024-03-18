package GFGProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CreatingString {
    public static String createString(int n, int k, String s) {
        String ans = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        System.out.println(map);
        for (Entry<Character, Integer> it : map.entrySet()) {
            Integer currKeySize = it.getValue();
            if (currKeySize >= k) {
                char curr = it.getKey();
                for (int i = 0; i < k; i++) {
                    System.out.println(curr);
                    ans += curr;
                }
                currKeySize--;
            }
            map.remove(it.getKey());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(createString(5, 2, "zzaaa"));
    }
}
