package LeetCode.DFSBFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1091ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        if (grid[0][0] != 0 || grid[m - 1][m - 1] != 0) {
            return -1;
        }

        // 8 direction
        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, -1, 1, -1, 1};

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        int count = 0;
        grid[0][0] = 1;//visited marked as 1
        while (!deque.isEmpty()) {
            int size = deque.size();
            count++;
            for (int i = 0; i < size; i++) { // BFS this level
                int[] temp = deque.poll();
                int x = temp[0];
                int y = temp[1];
                if (x == (m - 1) && y == m - 1) {
                    return count;
                }
                for (int j = 0; j < 8; j++) {
                    int xx = x + dx[j];
                    int yy = y + dy[j];
                    if (xx >= 0 && xx < m && yy >= 0 && yy < m && grid[xx][yy] == 0) { // add next level
                        deque.offer(new int[]{xx, yy});
                        grid[xx][yy] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
