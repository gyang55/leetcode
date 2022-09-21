public class Manacher {
    /**
     * manacher algorithm
     */

    public static int maxLcpslength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s); // 1221=#1#2#2#1#
        int[] pArr = new int[str.length];// 回文半径数组
        int center = -1;//中心
        int R = -1;//回文右边界再往右一个位置
        int max = Integer.MIN_VALUE; //扩出来的最大值;
        for (int i = 0; i != str.length; i++) {
            //先算出i位置至少的回文区
            pArr[i] = R > i ? Math.min(pArr[2 * center - i], R - i) : 1;

            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                center = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1; //返回的是原始串最大回文的长度

    }

    private static char[] manacherString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int newLength = s.length() * 2 + 1;
        for (int i = 0; i < newLength; i++) {
            if (i % 2 == 0) {
                stringBuilder.append('#');
                continue;
            }
            stringBuilder.append(s.charAt((i - 1) / 2));
        }
        return stringBuilder.toString().toCharArray();
    }

    public static void main(String[] args) {

        System.out.println(maxLcpslength("121"));
    }
}
