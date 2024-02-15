package LeetCode.arrays;

public class Leetcode283MoveZeroes {
//    public void moveZeroes(int[] nums) {
//        int nonZero = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[nonZero++] = nums[i];
//            }
//        }
//        for (int i = nonZero; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//    }

//    //official solution
//    public void moveZeroes(int[] nums) {
//        int n = nums.length, left = 0, right = 0;
//        while (right < n) {
//            if (nums[right] != 0) {
//                swap(nums, left, right);
//                left++;
//            }
//            right++;
//        }
//    }
//
//    void swap(int[] nums, int left, int right) {
//        int temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
//    }

    //most voted
//    public void moveZeroes(int[] nums) {
//        int snowBallSize = 0;
//        for (int i=0;i<nums.length;i++){
//            if (nums[i]==0){
//                snowBallSize++;
//            }
//            else if (snowBallSize > 0) {
//                int t = nums[i];
//                nums[i]=0;
//                nums[i-snowBallSize]=t;
//            }
//        }
//    }

    public void moveZeroes(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
                continue;}
            nums[i - snowBallSize] = nums[i];
        }

        while (snowBallSize > 0) {
            nums[nums.length - snowBallSize--] = 0;
        }
    }
}
