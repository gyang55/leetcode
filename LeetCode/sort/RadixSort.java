package sort;

import java.util.Arrays;


public class RadixSort {
    /**
     * 基于LSD
     * */
    public static void radixSortLSD(int[] arr) {
        if (arr == null) return;
        // 找出最长的数
        int max = 0;
        for (int value : arr) {
            if (Math.abs(value) > max) {
                max = Math.abs(value);
            }
        }
        // 计算最长数字的长度
        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }
        // 使用计数排序算法对基数进行排序，下标 [0, 18] 对应基数 [-9, 9]
        int[] counting = new int[19];
        int[] result = new int[arr.length];
        int dev = 1;
        for (int i = 0; i < maxDigitLength; i++) {
            for (int value : arr) {
                // 下标调整
                int radix = value / dev % 10 + 9;
                counting[radix]++;
            }
            for (int j = 1; j < counting.length; j++) {
                counting[j] += counting[j - 1];
            }
            // 使用倒序遍历的方式完成计数排序
            for (int j = arr.length - 1; j >= 0; j--) {
                // 下标调整
                int radix = arr[j] / dev % 10 + 9;
                result[--counting[radix]] = arr[j];
            }
            // 计数排序完成后，将结果拷贝回 arr 数组
            System.arraycopy(result, 0, arr, 0, arr.length);
            // 将计数数组重置为 0
            Arrays.fill(counting, 0);
            dev *= 10;
        }
    }

    /**
     * 基于MSD
     * */
    public static void radixSortMSD(int[] arr) {
        if (arr == null) return;
        // 找到最大值
        int max = 0;
        for (int value : arr) {
            if (Math.abs(value) > max) {
                max = Math.abs(value);
            }
        }
        // 计算最大长度
        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }
        radixSort(arr, 0, arr.length - 1, maxDigitLength);
    }

    // 对 arr 数组中的 [start, end] 区间进行基数排序
    private static void radixSort(int[] arr, int start, int end, int position) {
        if (start == end || position == 0) return;
        // 使用计数排序对基数进行排序
        int[] counting = new int[19];
        int[] result = new int[end - start + 1];
        int dev = (int) Math.pow(10, position - 1);
        for (int i = start; i <= end; i++) {
            // MSD, 从最高位开始
            int radix = arr[i] / dev % 10 + 9;
            counting[radix]++;
        }
        for (int j = 1; j < counting.length; j++) {
            counting[j] += counting[j - 1];
        }
        // 拷贝 counting，用于待会的递归
        int[] countingCopy = new int[counting.length];
        System.arraycopy(counting, 0, countingCopy, 0, counting.length);
        for (int i = end; i >= start; i--) {
            int radix = arr[i] / dev % 10 + 9;
            result[--counting[radix]] = arr[i];
        }
        // 计数排序完成后，将结果拷贝回 arr 数组
        System.arraycopy(result, 0, arr, start, result.length);
        // 对 [start, end] 区间内的每一位基数进行递归排序
        for (int i = 0; i < counting.length; i++) {
            radixSort(arr, i == 0 ? start : start + countingCopy[i - 1], start + countingCopy[i] - 1, position - 1);
        }
    }
}

