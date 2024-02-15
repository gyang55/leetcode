public class RussianPeasantMultiplication {
    public static int russianPeasant(int a, int b) {
        int result = 0;
        while (b > 0) {
            // If second number becomes odd,
            // add the first number to result
            if ((b & 1) != 0) {
                result += a;
            }
            a = a << 1;
            b = b >> 1;
        }
        return result;
    }
    public static void main (String[] args)
    {
        System.out.println(russianPeasant(50, 65));
        System.out.println(russianPeasant(20, 12));
    }

}
