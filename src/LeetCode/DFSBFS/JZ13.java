package LeetCode.DFSBFS;

import datastructure.queue.Queue;

import java.util.Deque;
import java.util.LinkedList;

public class JZ13 {
    //机器人运动范围
    //BFS use queue
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Deque<int[]> deque = new LinkedList<>();
        int[] dx = {0, 1};
        int[] dy = {1, 0};

        boolean[][] vis = new boolean[m][n];
        deque.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!deque.isEmpty()) {
            int[] cell = deque.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n | vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                deque.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
