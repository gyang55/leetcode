package LeetCode.backtracking;

public class Leetcode79WordSearch {
    public boolean exist(char[][] board, String word) {
        int length = board.length;
        int arrLength = board[0].length;
        boolean[][] visited = new boolean[length][arrLength];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < arrLength; j++) {
                boolean flag = dfs(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word, int target) {
        if (board[x][y] != word.charAt(target)) {
            return false;
        } else if (target == word.length() - 1) {
            return true;
        }

        visited[x][y] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;

        for (int[] dir : directions
        ) {
            int newx = x + dir[0], newy = y + dir[1];
            if (newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length) {
                if (!visited[newx][newy]) {
                    boolean flag = dfs(board, visited, newx, newy, word, target + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[x][y] = false;
        return result;
    }
}
