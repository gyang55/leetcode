package LeetCode.arrays;

public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        //用两个数组标记该行和该列是否应该为0
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean[] rowCount = new boolean[rowNum];
        boolean[] colCount = new boolean[colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == 0) {
                    rowCount[i] = true;
                    colCount[j] = true;
                }
            }

        }
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (rowCount[i] == true || colCount[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
