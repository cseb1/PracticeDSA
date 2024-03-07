public class Panagram {
    public static boolean checkPangram(String s) {
        // your code here
        boolean[] mat = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = 0;
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                idx = s.charAt(i) - 'A';
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                idx = s.charAt(i) - 'a';
            } else
                continue;

            mat[idx] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (mat[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(checkPangram(str));

        System.out.println(checkPangram("sdfg"));
    }
}
