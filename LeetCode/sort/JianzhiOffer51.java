package sort;

public class JianzhiOffer51 {
    int count;
    int[] nums;

    public int reversePairs(int[] nums) {
        this.count = 0;
        this.nums = nums;
        merge(this.nums, 0, this.nums.length - 1);
        return count;
    }

    public void merge(int[] nums, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            merge(nums, left, mid);
            merge(nums, mid + 1, right);
            mergeSort(nums, left, mid, right);
        }
    }

    public void mergeSort(int[] nums, int left, int mid, int right) {
        int[] temparr = new int[right - left + 1];
        int index = 0;
        int temp1 = left, temp2 = mid + 1;

        while (temp1 <= mid && temp2 <= right) {
            if (nums[temp1] <= nums[temp2]) {
                temparr[index++] = nums[temp1++];
            } else {
                //用来统计逆序对的个数
                count += (mid - temp1 + 1);
                temparr[index++] = nums[temp2++];
            }
        }
        //把左边剩余的数移入数组
        while (temp1 <= mid) {
            temparr[index++] = nums[temp1++];
        }
        //把右边剩余的数移入数组
        while (temp2 <= right) {
            temparr[index++] = nums[temp2++];
        }
        //把新数组中的数覆盖nums数组
        for (int k = 0; k < temparr.length; k++) {
            this.nums[k + left] = temparr[k];
        }
    }

    /**
     * official
     */

    class Solution {
        public int reversePairs(int[] nums) {
            if (nums.length == 0) return 0;
            int[] result = new int[nums.length];
            return mergeSortAndCount(nums, 0, nums.length - 1, result);
        }

        // 对 arr 的 [start, end] 区间归并排序
        private static int mergeSortAndCount(int[] arr, int start, int end, int[] result) {
            // 只剩下一个数字，停止拆分
            if (start == end) return 0;
            int middle = (start + end) / 2;
            // 拆分左边区域，并将归并排序的结果保存到 result 的 [start, middle] 区间，记录左边逆序对数量
            int leftCount = mergeSortAndCount(arr, start, middle, result);
            // 拆分右边区域，并将归并排序的结果保存到 result 的 [middle + 1, end] 区间，记录右边逆序对数量
            int rightCount = mergeSortAndCount(arr, middle + 1, end, result);
            // 合并左右区域到 result 的 [start, end] 区间，记录合并过程中的逆序对数量
            int crossCount = mergeAndCount(arr, start, end, result);
            // 三者之和就是 [start, end] 区间内产生的所有逆序对数量
            return leftCount + rightCount + crossCount;
        }

        // 将 result 的 [start, middle] 和 [middle + 1, end] 区间合并，并记录逆序对数量
        private static int mergeAndCount(int[] arr, int start, int end, int[] result) {
            int count = 0;
            int end1 = (start + end) / 2;
            int start2 = end1 + 1;
            // 用来遍历数组的指针
            int index1 = start;
            int index2 = start2;
            while (index1 <= end1 && index2 <= end) {
                if (arr[index1] <= arr[index2]) {
                    result[index1 + index2 - start2] = arr[index1++];
                } else {
                    result[index1 + index2 - start2] = arr[index2++];
                    // 当右边数字较小时，统计左边剩余数字的数量，也就是此数字可与左边数组组成的逆序对数量
                    count += end1 - index1 + 1;
                }
            }
            // 将剩余数字补到结果数组之后
            while (index1 <= end1) {
                result[index1 + index2 - start2] = arr[index1++];
            }
            while (index2 <= end) {
                result[index1 + index2 - start2] = arr[index2++];
            }
            // 将 result 操作区间的数字拷贝到 arr 数组中，以便下次比较
            while (start <= end) {
                arr[start] = result[start++];
            }
            return count;
        }
    }

}