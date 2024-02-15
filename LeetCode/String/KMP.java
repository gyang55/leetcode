public class KMP {
    public static int kmp(String str, String pattern) {
        if (str == null || pattern == null || pattern.length() < 1 || str.length() < pattern.length()) {
            return -1;
        }
        char[] strCharArray = str.toCharArray();
        char[] patternCharArray = pattern.toCharArray();

        int positionInStr = 0;
        int positionInPattern = 0;
        int[] next = getNextArray(patternCharArray); //O(pattern.length())
        //O(n)
        while (positionInStr < str.length() && positionInPattern < pattern.length()) {
            if (strCharArray[positionInStr] == patternCharArray[positionInPattern]) {
                positionInStr++;
                positionInPattern++;

            } else if (next[positionInPattern] == -1) { //等同于positionInPattern == 0 来到了pattern的第一个字符
                positionInStr++;
            } else {
                positionInPattern = next[positionInPattern];
            }
        }

        // 检查到最后positionInPattern是否与patternCharArray的长度相等，相等说明找到了
        return positionInPattern == patternCharArray.length ? positionInStr - positionInPattern : -1;
    }

    public static int[] getNextArray(char[] chaArray) {
        if (chaArray.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[chaArray.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; //next数组的位置
        int cn = 0;
        while (i < next.length) {
            if (chaArray[i - 1] == chaArray[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
