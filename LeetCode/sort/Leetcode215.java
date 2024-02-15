package sort;

import java.util.Random;

public class Leetcode215 {
    /**
     * 利用堆排序*/
//    public static int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> kthBig = new PriorityQueue<Integer>((n1,n2)-> n1 - n2);
//        for (int i = 0; i < nums.length; i++) {
//            kthBig.add(nums[i]);
//            if (kthBig.size() > k) {
//                kthBig.poll();
//            }
//        }
//
//        return kthBig.poll();
//    }
    /**
     * 利用库
     * */
//    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length-k];
//    }


    /**
     * 利用快速排序
     */
    private final static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        // 第 1 大的数，下标是 len - 1;
        // 第 2 大的数，下标是 len - 2;
        // ...
        // 第 k 大的数，下标是 len - k;
        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len - 1;

        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                // pivotIndex > target
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);


        // all in nums[left + 1..le) <= pivot;
        // all in nums(ge..right] >= pivot;
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;

        while (true) {
            //Find the first number greater than pivot, otherwise le move to right
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            //Find the first number less than pivot, otherwise le move to right
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(nums, left, ge);
        return ge;
    }

    private void swap(int[] nums, int index1, int index2) {
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index2] ^ nums[index1];
        nums[index1] = nums[index1] ^ nums[index2];
//        int temp = nums[index1];
//        nums[index1] = nums[index2];
//        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(new Leetcode215().findKthLargest(nums, 4));
    }
}
