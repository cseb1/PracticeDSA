package Leetcodeproblem;

//https://leetcode.com/problems/group-anagrams/description/?envType=daily-question&envId=2024-02-06
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsPrint {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (!mp.containsKey(sortedStr)) {
                mp.put(sortedStr, new ArrayList<>());
            }
            mp.get(sortedStr).add(strs[i]);
        }

        for (List<String> group : mp.values()) {
            ans.add(group);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}
