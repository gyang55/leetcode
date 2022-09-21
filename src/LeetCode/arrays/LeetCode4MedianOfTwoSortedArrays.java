package LeetCode.arrays;

public class LeetCode4MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = mergeTwoArrays(nums1, nums2);
        int length = merged.length;
        int mid = length / 2;
        for (int i = 0; i < length; i++) {
            System.out.print(merged[i]+" ");
        }
        if (length % 2 == 0) {
            return (merged[mid] + merged[mid - 1])/2.0;

        }else {
            return merged[mid];
        }
    }

    private static int[] mergeTwoArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int indexMerged = 0;
        int[] merged = new int[nums1.length + nums2.length];
        while (index1 < nums1.length && index2 < nums2.length) {
            merged[indexMerged++] = nums1[index1] <= nums2[index2] ? nums1[index1++] : nums2[index2++];
        }

        if (index1 >= nums1.length) {
            while (index2 < nums2.length) {
                merged[indexMerged++] = nums2[index2++];
            }
        } else {
            while (index1 < nums1.length) {
                merged[indexMerged++] = nums1[index1++];
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println(LeetCode4MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
