package LeetCode.arrays;

public class LeetCode80RemoveDuplicateFromSortedArray2 {
    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int n : nums
        ) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args){
        int[] arr={1,1,1,2,2,2,4};
        System.out.println(removeDuplicates(arr));
    }
}
