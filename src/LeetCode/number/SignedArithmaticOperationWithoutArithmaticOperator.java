package LeetCode.number;

public class SignedArithmaticOperationWithoutArithmaticOperator {
    /**
     * 异或就是无进位相加
     * 与后再向左移一位是进位信息
     */

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;  //无进位相加
            b = (a & b) << 1; //进位信息
            a = sum;
        }
        return sum;
    }

    /**
     * 一个数的相反数就是这个数取反然后+1
     */
    public static int negNum(int n) {
        return add(~n, 1);
    }

    //减法就是加上这个数的相反数
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multiply(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }
}
