
// leetcode problem

/*
 Approach
1. Implement a recursive function backtrack that takes the current position (i, j) in the grid and the current index k of the word.
2.Base cases:
If k equals the length of the word, return True, indicating that the word has been found.
If the current position (i, j) is out of the grid boundaries or the character at (i, j) does not match the character at index k of the word, return False.
3.Mark the current cell as visited by changing its value or marking it as empty.
4. Recursively explore all four directions (up, down, left, right) by calling backtrack with updated positions (i+1, j), (i-1, j), (i, j+1), and (i, j-1).
5.If any recursive call returns True, indicating that the word has been found, return True.
6. If none of the recursive calls returns True, reset the current cell to its original value and return False.
7. Iterate through all cells in the grid and call the backtrack function for each cell. If any call returns True, return True, indicating that the word exists in the grid. Otherwise, return False
 */

class Solution {
    // Simple DFS call

    // we can search word in 4 direction so backtrack call
    // these 4 direction we call DFS function

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = dfs(board, visited, word, i, j, 0);
                    if (result == true)
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        int n = board.length;
        int m = board[0].length;
        // base case
        if (k == word.length()) {
            // we found the word
            return true;
        }

        // out of boundary base case
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(k) || visited[i][j] == true) {
            return false;
        }

        visited[i][j] = true;
        if (dfs(board, visited, word, i - 1, j, k + 1) ||
                dfs(board, visited, word, i + 1, j, k + 1) ||
                dfs(board, visited, word, i, j - 1, k + 1) ||
                dfs(board, visited, word, i, j + 1, k + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}

public class WordSearch {

    // public static void main(String[] args) {

    // System.out.println(exist(
    // new char[][] { { "A", "B", "C", "E" }, { "S", "F", "C", "S" }, { "A", "D",
    // "E", "E" } }, "ABCCED"));
    // }

    public static void main(String[] args) {
        System.out.println("Hello Susanta");
    }

}
