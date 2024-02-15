package LeetCode.number;

public class BiggerNunber {
    //请保证参数n，不是1就是0的情况下 1-》0， 0-》1
    public static int flip(int n) {
        return n ^ 1;
    }

    //n是非负数，返回1
    //n是负数，返回0
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    //这个方法c有可能溢出
    public static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    /**
     * 返回A的条件是ab符号相同a-b>=0,或者ab不同a>0
     * 返回B的条件于A互斥
     *
     * */
    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int diffSab = sa ^ sb;
        int sameSab = flip(diffSab);
        int returnA = diffSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }
}
