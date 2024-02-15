package search;

import javax.xml.stream.events.StartDocument;

public class LeetCode74SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1}};
        int target = 1;
        System.out.print(searchMatrix(matrix,target));
    }
}
