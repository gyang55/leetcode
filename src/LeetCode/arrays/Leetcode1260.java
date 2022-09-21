package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1260 {
    /**
     * 先转化为一维数组，k次迁移后位置为 i*n+j+k %(m*n) = index, 然后在二维
     * 数组的位置为 index/n, index%n
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int row = grid.length;
        int length = grid[0].length;
        for (int i = 0; i < row; i++) {
            List<Integer> box = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                box.add(0);
            }
            res.add(box);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < length; j++) {
                int index = (i * length + j + k)%(row*length);
                res.get(index / length).set(index % length, grid[i][j]);
            }
        }
        return res;
    }
}
