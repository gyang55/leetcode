package search;

import java.util.Arrays;

public class LeetCode1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for (int n : arr1
        ) {
            //找到arr1 element右边第一个位置的下标
            int arr2Ele = binarySearch(arr2, n);
            //判断arr1 前后值的distance
            boolean ok = true;
            if (arr2Ele < arr2.length) {
                ok &= arr2[arr2Ele] - n > d;
            }

            if (arr2Ele - 1 >= 0 && arr2Ele - 1 < arr2.length) {
                ok &= n-arr2[arr2Ele - 1] > d;
            }

            res += ok ? 1 : 0;
        }
        return res;
    }

    private int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        if (arr[right] < n) {
            return right + 1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
