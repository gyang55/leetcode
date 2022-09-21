package search;

public class Leetcode33SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int length = nums.length;
        int separatePoint = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                separatePoint = i;
                break;
            }
        }
        int pre = biSearch(nums, target, 0, separatePoint);
        int latter = biSearch(nums, target, separatePoint + 1, length - 1);
        if (pre == -1 && latter == -1) {
            return -1;
        }
        return pre == -1 ? latter : pre;
    }

    private static int biSearch(int[] nums, int target, int start, int end) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.print(search(nums, 0));
    }
}
