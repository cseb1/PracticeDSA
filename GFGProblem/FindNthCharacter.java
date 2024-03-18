package GFGProblem;

//https://www.geeksforgeeks.org/problems/find-the-n-th-character5925/1
public class FindNthCharacter {
    public static char nthCharacter(String s, int r, int n) {
        for (int i = 0; i < r; i++) {
            String s2 = "";
            int ns = s.length();
            for (int j = 0; j < ns; j++) {
                if (s.charAt(j) == '0') {
                    s2 += "01";
                }
                if (s.charAt(j) == '1') {
                    s2 += "10";
                }
                if (s2.length() > s.length())
                    break;
            }
            s = s2;
        }
        return s.charAt(n);

    }

    public static void main(String[] args) {
        System.out.println(nthCharacter("1100", 2, 3));
    }
}
