package LeetCode.arrays;

public class Leetcode566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if (row * col != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < row * col; i++) {
            res[i / c][i % c] = mat[i / col][i % col];
        }
        return res;

    }
}
