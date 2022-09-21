package search;

public class LeetCode1351CountNegativeNumsInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            count += binaryCount(grid[i]);
        }
        return count;
    }

    private int binaryCount(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int length = arr.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= 0) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return length - left;
    }
}
