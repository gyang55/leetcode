package LeetCode.number;

public class LeetCode592FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        long denominatorRes = 1;
        long numeratorRes = 0;
        int length = expression.length();
        int index = 0;
        while (index < length) {
            long denominator = 0;
            long numerator = 0;
            int sign = 1; //default, if the first char is not '-' or '+', then sign =1;
            //read sign
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index++) == '-' ? -1 : 1;
            }

            //read numerator
            //用while coz multiple digits like 143
            // 0 + '0' = 48 ascuii so need to -'0'
            while (index < length && Character.isDigit(expression.charAt(index))) {
                numerator = numerator * 10 + expression.charAt(index++) - '0';
            }
            numerator = sign * numerator;
            index++; // skip '/'

            //read denominator
            while (index < length && Character.isDigit(expression.charAt(index))) {
                denominator = denominator * 10 + expression.charAt(index++) - '0';
            }
            numeratorRes = numeratorRes * denominator + numerator * denominatorRes;
            denominatorRes *= denominator;


        }
        if (numeratorRes == 0) {
            return "0/1";
        }

        long g = gcd(Math.abs(numeratorRes), denominatorRes);
        return Long.toString(numeratorRes / g) + "/" + Long.toString(denominatorRes / g);
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
