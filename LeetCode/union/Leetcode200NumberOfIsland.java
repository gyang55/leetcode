package LeetCode.union;

public class Leetcode200NumberOfIsland {
    /**
     * 岛屿问题框架
     */
//    void dfs(int[][] grid, int r, int c) {
//        // 判断 base case
//        if (!inArea(grid, r, c)) {
//            return;
//        }
//        // 如果这个格子不是岛屿，直接返回
//        if (grid[r][c] != 1) {
//            return;
//        }
//        grid[r][c] = 2; // 将格子标记为「已遍历过」,避免重复遍历
//
//        // 访问上、下、左、右四个相邻结点
//        dfs(grid, r - 1, c);
//        dfs(grid, r + 1, c);
//        dfs(grid, r, c - 1);
//        dfs(grid, r, c + 1);
//    }
//
//    // 判断坐标 (r, c) 是否在网格中
//    boolean inArea(int[][] grid, int r, int c) {
//        return 0 <= r && r < grid.length
//                && 0 <= c && c < grid[0].length;
//    }
    public static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null || (grid.length > 1 && grid[0].length == 0)) return 0;
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int numOfIsland = 0;

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == '1') {
                    numOfIsland++;
                    dfs(grid, i, j);
                }
            }
        }
        return numOfIsland;
    }

    private static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col <= 0 || col >= grid[0].length || grid[row][col] != '1') return;

        grid[row][col] = '2'; //marked as visited

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public static void main(String[] args) {
        char[][] input = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(input));
    }
}
