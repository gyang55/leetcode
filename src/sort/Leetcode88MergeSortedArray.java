package sort;

public class Leetcode88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        for (int index = k - 1, num1Index = m - 1, num2Index = n - 1; index >= 0; index--) {
            if (num1Index < 0) {
                nums1[index] = nums2[num2Index--];
            } else if (num2Index < 0) {
                break;
            } else if (nums1[num1Index] > nums2[num2Index]) {
                nums1[index] = nums1[num1Index--];
            } else {
                nums1[index] = nums2[num2Index--];
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 1, 2, 0, 0, 0};
        int[] num2 = {4, 5, 6};
        new Leetcode88MergeSortedArray().merge(num1, 3, num2, 3);
        for (Integer n : num1
        ) {
            System.out.print(n + " ");
        }
    }
}
