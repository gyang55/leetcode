package LeetCode.String;

public class Leetcode6ZigZagConversion {
    public String convert(String s, int nRows) {
        int length = s.length();
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        while (i < length) {
            for (int j = 0; j < nRows && i < length; j++) {
                sb[j].append(s.charAt(i++));
            }
            for (int j = nRows - 2; j >= 1 && i < length; j--) {
                sb[j].append(s.charAt(i++));
            }
        }

        for (int j = 1; j < sb.length; j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}
