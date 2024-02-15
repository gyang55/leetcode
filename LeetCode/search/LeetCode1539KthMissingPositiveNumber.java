package search;

public class LeetCode1539KthMissingPositiveNumber {
    /**
     * 第i个前面missing个数为ai - i - 1
     */
    public int findKthPositive(int[] arr, int k) {
        // 第一个数比缺失的数要大的话，直接返回k
        if (arr[0] > k) {
            return k;
        }
        int left = 0;
        int right = arr.length; //当数组不缺数字时，为了让最终的指针返回数组最后一个元素再往后一个
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return k - (arr[left - 1] - (left - 1) - 1) + arr[left - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        System.out.print(new LeetCode1539KthMissingPositiveNumber().findKthPositive(arr, 5));
    }

}
