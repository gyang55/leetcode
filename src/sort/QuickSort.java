package sort;

import java.util.Random;

public class QuickSort {
    public static final Random random = new Random(System.currentTimeMillis());
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int posPartition = randPartition(nums, left, right);
        quickSort(nums, left, posPartition - 1);
        quickSort(nums, posPartition + 1, right);
    }

    private int randPartition(int[] nums, int left, int right) {
        int randPivot = random.nextInt(right - left + 1) + left;
        swap(nums, right, randPivot);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int smallIndex = left-1;
        for (int i = left; i <= right - 1; i++) {
            if (nums[i] <= pivot) {
                swap(nums, ++smallIndex, i);
            }
        }
        swap(nums, ++smallIndex, right);

        return smallIndex;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
