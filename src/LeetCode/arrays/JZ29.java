package LeetCode.arrays;

public class JZ29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }

        int col = matrix.length;
        int row = matrix[0].length;
        int[] order = new int[row * col];
        int index = 0;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            for (int y = left; y <= right; y++) {
                order[index++] = matrix[top][y];
            }
            for (int x = top + 1; row <= bottom; row++) {
                order[index++] = matrix[x][right];
            }
            if (left < right && top < bottom) {
                for (int y = right - 1; y > left; y--) {
                    order[index++] = matrix[bottom][y];
                }
                for (int x = bottom; x > top; x--) {
                    order[index++] = matrix[x][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
