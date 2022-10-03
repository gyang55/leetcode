package LeetCode.backtracking;

public class JZ46 {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * <p>
     * 思路：：dp[i]代表到xi翻译数量方案。
     * dp[i-1] 为单独翻译xi的数量
     * dp[i-2] 为一起翻译xi和xi-1的数量
     * dp[i]=dp[i-1] + dp[i-2]
     */

//    public int translateNum(int num) {
//        String s = String.valueOf(num);
//        //用两个变量记录dp[i-1] dp[i-2] dp[0]初始化为1 dp[1]=1
//        int pre = 1, prepre = 1;
//        for (int i = 2; i <= s.length(); i++) {
//            String tmp = s.substring(i - 2, i);
//            int cur = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? pre + prepre : pre;
//            prepre = pre;
//            pre = cur;
//
//        }
//        return pre;
//    }

    //求余
    public int translateNum(int num) {
        int last = 1, lastLast = 1, curDigit, nextDigit = num % 10;
        while (num != 0) {
            num /= 10;
            curDigit = num % 10;
            int curTemp = 10 * curDigit + nextDigit;
            int curCount = (curTemp >= 10 && curTemp <= 25) ? last + lastLast : last;
            lastLast = last;
            last = curCount;
            nextDigit = curDigit;
        }
        return last;
    }
}
