package LeetCode.recursive;

public class ConvertNumberToLetterString {

    public static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == 0) {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1);//算出后续的部分
            if (i + 1 < str.length) {
                res += process(str, i + 2); //i和i+1作为单独的部分，算出后续有多少种方法
            }
            return res;
        }

        if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str, i + 2);
            }
            return res;
        }

        return process(str, i + 1);
    }
}
