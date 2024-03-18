package GFGProblem;

//https://www.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1
import java.util.HashMap;
import java.util.Map;

public class RemoveAllDuplicates {
    static String removeDuplicates(String str) {
        Map<Character, Integer> map = new HashMap<>();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                // it is first time
                ans += str.charAt(i);
                map.put(str.charAt(i), 1);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("geEksforGEeks"));
    }
}
