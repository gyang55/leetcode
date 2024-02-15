package LeetCode.number;

public class WhetherANumberIsPowerOf2And4 {
    /**
     * 判断一个32位正数是否是2或则4的幂
     * 如果一个数是2的幂，那么这个数bit图里面只有一个1，然后 - 1 再 &这个数自己一定是0
     * 如果一个数是4的幂，那么这个数首先是2的幂，然后它的bit图中1的位置只能是0,2,4，。。。。
     */

    public static boolean is2Power(int n) {
        return (n & (n - 1)) == 0;
    }

    public static boolean is4Power(int n) {
        return (n & (n - 1)) == 0 && ((n & 0x55555555)) != 0; //0x55555555 =010101..010101
    }
}
