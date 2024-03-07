package GFGProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexographicallySorted {
    public static List<String> AllPossibleStrings(String s) {
        // Code here
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                // check if the ith bit is set or not
                if ((num & (1 << i)) != 0) {
                    sub += s.charAt(i);
                }
            }
            if (sub.length() > 0) {
                ans.add(sub);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(AllPossibleStrings("abc"));
        System.out.println(AllPossibleStrings("aa"));
    }
}
