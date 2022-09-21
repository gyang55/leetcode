package LeetCode.duoPointers;

public class LeetCode189RotateArray {
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        int count = gcd(k, nums.length);
//        for (int i = 0; i < count; i++) {
//            int current = i;
//            int previous = nums[i];
//            do {
//                int next = (current + k) % nums.length;
//                int temp = nums[next];
//                nums[next] = previous;
//                previous = temp;
//                current = next;
//            } while (current != i);
//        }
//    }
//
//    private int gcd(int x, int y) {
//        return y > 0 ? gcd(y, x % y) : x;
//    }

    /**
     * reverse array
     * */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
