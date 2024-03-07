
public class ColorMatching {
    static boolean visited[] = new boolean[26];

    public static int slotScore(String original, String guess) {
        // Write your code here.
        return calcResult(guess, original);

    }

    static int hits = 0;
    static int pseudoHits = 0;

    // Function to assign code to a slot
    // based on the color they have
    static int codeOfColor(char c) {
        switch (c) {
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }

    // maximum no of colors are 4 RGYB
    static int MAX_COLORS = 4;

    // Function to calculate number of hits
    // and pseudo hits
    static int calcResult(String guess, String solution) {
        hits = 0;
        pseudoHits = 0;

        if (guess.length() != solution.length())
            return 0;

        // frequency array to store how many times
        // each character occurs in solution string
        int[] frequencies = new int[MAX_COLORS];

        // Compute hits and build frequency table
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                hits++;
            } else {
                /*
                 * Only increment the frequency table (which will be
                 * used for pseudo-hits) if it's not a hit. If it's a
                 * hit, the slot has already been "used."
                 */
                int codeofcolor = codeOfColor(solution.charAt(i));
                frequencies[codeofcolor]++;
            }
        }

        // Compute pseudo-hits
        for (int i = 0; i < guess.length(); i++) {
            int codeofcolor = codeOfColor(guess.charAt(i));
            if (codeofcolor >= 0 && frequencies[codeofcolor] > 0 &&
                    guess.charAt(i) != solution.charAt(i)) {
                pseudoHits++;
                frequencies[codeofcolor]--;
            }
        }
        return ((hits * 2) + (pseudoHits * 1));

    }

    public static void main(String[] args) {
        // System.out.println(slotScore("RGYB", "YGRR"));
        System.out.println(slotScore("RGBY", "GGRR"));
    }
}
