package LeetCode.arrays;

public class Test {
    private static void swap(int[] nums, int left, int right) {
        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[right] ^ nums[left];
        nums[left] = nums[left] ^ nums[right];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2,3,4,5,6,};
        swap(nums, 3, 4);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
