package LeetCode.backtracking;

//class Solution {
//    List<List<String>> res = new LinkedList<>();
//
//    public List<List<String>> solveNQueens(int n) {
//        char[][] board = new char[n][n];
//        for (char[] cs : board) {
//            Arrays.fill(cs, '.');
//        }
//        helper(board, 0, 0, n);
//        return res;
//    }
//
//    private void helper(char[][] board, int row, int col, int n) {
//        // Column out of bound
//        if (col == board[0].length) {
//            col = 0;
//            row++;
//        }
//        // n is 0 then add to the res
//        if (n == 0) {
//            res.add(toString(board));
//            return;
//        }
//        // Row out of bound
//        if (row == board.length)
//            return;
//
//        // Place queen here if valid
//        if (isValid(board, row, col)) {
//            board[row][col] = 'Q';
//            n--;
//            helper(board, row, col + 1, n);
//            // backtrack unchoose the option
//            board[row][col] = '.';
//            n++;
//        }
//
//        // Skip this cell, we place a '.'
//        helper(board, row, col + 1, n);
//    }
//
//    private List<String> toString(char[][] board) {
//        List<String> list = new LinkedList<>();
//        StringBuilder str;
//        for (char[] cs : board) {
//            str = new StringBuilder();
//            for (char cur : cs) {
//                str.append(cur);
//            }
//            list.add(str.toString());
//        }
//        return list;
//    }
//
//    private boolean isValid(char[][] board, int row, int col) {
//        int N = board.length;
//        // TOP AND DOWN
//        for (int i = 0; i < N; i++) {
//            if (board[i][col] != '.')
//                return false;
//            if (board[row][i] != '.')
//                return false;
//        }
//        // Top left + top right + down left + down right
//        int i = row, j = col;
//        // Top left
//        while (0 <= i && 0 <= j) {
//            if (board[i][j] != '.')
//                return false;
//            i--;
//            j--;
//        }
//        // Top right
//        i = row;
//        j = col;
//        while (0 <= i && j < N) {
//            if (board[i][j] != '.')
//                return false;
//            i--;
//            j++;
//        }
//        // Down Right
//        i = row;
//        j = col;
//        while (i < N && j < N) {
//            if (board[i][j] != '.')
//                return false;
//            i++;
//            j++;
//        }
//        // Down left
//        i = row;
//        j = col;
//        while (i < N && 0 <= j) {
//            if (board[i][j] != '.')
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }
//}

public class Leetcode51NQueens {
    public static int num1(int n) {
        if (n < 1) return 0;
        int[] record = new int[n]; //第i行的皇后放在了哪一列
        return process1(0, record, n);
    }

    public static int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            //当前i行的皇后，放在j列，会不会和之前0.。。i-1的皇后，共行共列或者公斜线
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 另一种解法，用限制
     */

    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1; //int的lower n 位都是1
        return process2(limit, 0, 0, 0);
    }

    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);

        }
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(num1(n));
        System.out.println(num2(n));
    }
}