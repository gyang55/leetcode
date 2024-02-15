package search;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1337TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] powers = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                powers[i][0] = searchPower(mat[i]);
                powers[i][1] = i;
            }
        }
        int[][] minimum = Helper.getLeastNumbers(powers, k);
        Arrays.sort(minimum, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minimum[i][1];
        }
        return res;
    }

    private int searchPower(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    //quick selection
    class Helper {
        public static int[][] getLeastNumbers(int[][] arr, int k) {
            randomizedSelected(arr, 0, arr.length - 1, k);
            int[][] vec = new int[k][2];
            for (int i = 0; i < k; ++i) {
                vec[i][0] = arr[i][0];
                vec[i][1] = arr[i][1];
            }
            return vec;
        }

        private static void randomizedSelected(int[][] arr, int left, int right, int k) {
            if (left > right) {
                return;
            }
            int pos = randomizedPartition(arr, left, right);
            int num = pos - left + 1;
            if (k == num) {
                return;
            } else if (k < num) {
                randomizedSelected(arr, left, pos - 1, k);
            } else {
                randomizedSelected(arr, pos + 1, right, k - num);
            }
        }

        private static int randomizedPartition(int[][] nums, int left, int right) {
            int pivot = (int) (Math.random() * (right - left + 1)) + left;
            swap(nums, right, pivot);
            return partition(nums, left, right);
        }

        private static int partition(int[][] nums, int l, int r) {
            int[] pivot = nums[r];
            int i = l - 1;
            for (int j = l; j <= r - 1; ++j) {
                if (compare(nums[j], pivot) <= 0) {
                    swap(nums, ++i, j);
                }
            }
            swap(nums, ++i, r);
            return i;
        }

        private static int compare(int[] pair, int[] pivot) {
            if (pair[0] != pivot[0]) {
                return pair[0] - pivot[0];
            } else {
                return pair[1] - pivot[1];
            }
        }

        private static void swap(int[][] nums, int i, int j) {
            int[] temp = new int[nums[i].length];
            System.arraycopy(nums[i], 0, temp, 0, nums[i].length);
            System.arraycopy(nums[j], 0, nums[i], 0, nums[i].length);
            System.arraycopy(temp, 0, nums[j], 0, nums[i].length);
        }


    }
}
