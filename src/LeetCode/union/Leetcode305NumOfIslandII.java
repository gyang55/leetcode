package LeetCode.union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode305NumOfIslandII {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;

        int count = 0;
        int[] roots = new int[m * n]; //坐标2d to 1d
        Arrays.fill(roots, -1);

        for (int[] pair : positions
        ) {
            int position = n * pair[0] + pair[1];
            roots[position] = position;
            count++;
            for (int[] dir : directions
            ) {
                int x = pair[0] + dir[0];
                int y = pair[1] + dir[1];
                int curPos = n * x + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[curPos] == -1) {
                    continue;
                }
                int anotherIsland = find(roots, curPos);
                if (position != anotherIsland) {
                    roots[position] = anotherIsland;
                    position = anotherIsland;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (i != roots[i]) {
            i = roots[i];
        }
        return i;
    }
}
