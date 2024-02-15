package LeetCode.bitwise;

public class Leetcode201BitwiseANDOfNumberRange {
    /**
     * 右移两个临界点，直到两数相等，记录右移次数，想等后在左移这么多次数
     */
//    public int rangeBitwiseAnd(int left, int right) {
//        int shift = 0;
//        while (left < right) {
//            left = left >> 1;
//            right = right >> 1;
//            shift++;
//        }
//        return right << shift;
//    }

    /**
     * 让右边界数字n AND n-1，直到 n小于等于左边界，返回这个数
     */
    public int rangeBitwiseAnd(int left, int right) {

        while (right > left) {
            right = right * (right - 1);
        }
        return right;
    }

}
