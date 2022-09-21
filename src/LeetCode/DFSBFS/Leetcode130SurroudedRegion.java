package LeetCode.DFSBFS;


import java.util.LinkedList;
import java.util.Queue;

public class Leetcode130SurroudedRegion {
//    private int n;
//    private int m;
//
//    //DFS
//    public void solve(char[][] board) {
//        n = board.length;
//        m = board[0].length;
//        if (n == 0) {
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            dfs(board, i, 0);
//            dfs(board, i, m - 1);
//        }
//        for (int i = 1; i < m - 1; i++) {
//            dfs(board, 0, i);
//            dfs(board, n - 1, i);
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (board[i][j] == 'M') {
//                    board[i][j] = 'O';
//                } else if (board[i][j] == 'O') {
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }
//
//    private void dfs(char[][] board, int x, int y) {
//        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
//            return;
//        }
//        board[x][y] = 'M';
//        dfs(board, x + 1, y);
//        dfs(board, x - 1, y);
//        dfs(board, x, y + 1);
//        dfs(board, x, y - 1);
//    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    //BFS
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        if (n == 0) {
            return;
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
                board[i][m - 1] = 'A';
            }
        }

        for (int i = 1; i < m; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0,i});
                board[0][i] = 'A';
            }
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[]{n-1,i});
                board[n - 1][i] = 'A';
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || y < 0 ||xx >= n|| y >= m || board[xx][yy] != 'O') {
                    continue;
                }
                queue.offer(new int[]{xx, yy});
                board[xx][yy] = 'A';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

}
