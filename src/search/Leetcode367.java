package search;

import java.util.Arrays;

public class Leetcode367 {

        //利用二分法
        public boolean isPerfectSquare(int num) {
            int left = 0, right = num;
            while (left <= right) {
                int mid = (right - left) >> 2 + left;
                long square = (long) mid * mid;
                if (square < num) {
                    left = mid + 1;
                } else if (square > num) {
                    right = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args){
            int[] arr = {3,7};
            System.out.println(Arrays.binarySearch(arr,4));
        }
}
