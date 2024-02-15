import java.math.BigInteger;

/**
 * <p>
 * DynamicProgramming calculates LeetCode.number of different ways that someone can walk m blocks down and n blocks over on a grid.
 * </p>
 *
 * @author Guang Yang A01249847 set U
 */
public class DynamicProgramming {
    /**
     * <p>
     * Calculate LeetCode.number of paths recursively
     * </p>
     *
     * @param m the LeetCode.number of horizontal block
     * @param n the LeetCode.number of vertical block
     * @return LeetCode.number of ways from start to end
     */
    public static long SW_Recursive(int m, int n) {
        if (m == 1 && n == 1) {
            return 2;
        }
        if (m == 0 || n == 0) {
            return 1;
        }
        return SW_Recursive(m - 1, n) + SW_Recursive(m, n - 1);

    }

    /**
     * <p>
     * Calculate LeetCode.number of paths with Dynamic programming
     * </p>
     *
     * @param m the LeetCode.number of horizontal block
     * @param n the LeetCode.number of vertical block
     * @return LeetCode.number of ways from start to end
     */
    public static BigInteger SW_DynamicProg(int m, int n) {
        if (m == 1 && n == 1) {
            return BigInteger.valueOf(2);
        }
        if (m == 0 || n == 0) {
            return BigInteger.valueOf(1);
        }
        BigInteger[][] paths = new BigInteger[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            paths[0][i] = BigInteger.valueOf(1);
        }
        for (int i = 0; i <= n; i++) {
            paths[i][0] = BigInteger.valueOf(1);
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                paths[i][j] = paths[i - 1][j].add(paths[i][j - 1]);
            }
        }
        return paths[m - 1][n].add(paths[m][n - 1]);
    }


    /**
     * <p>
     * The SW_Dynamic calculate to 3737, please test it!!!!
     * </p>
     */
    public static void main(String[] args) {
        // Recursive way
        long startTimeRecursive = System.currentTimeMillis();
        for (int i = 0; i <= 17; i++) {
            System.out.println("SW_Recursive(" + i + "," + i + ") = " + SW_Recursive(i, i) + ", time is " + (System.currentTimeMillis() - startTimeRecursive) + " ms");
        }
        System.out.println();

        //Dynamic Programming
        long startTimeDynamic = System.currentTimeMillis();
        for (int i = 0; i <= 3737; i++) {
            System.out.println("SW_DynamicProg(" + i + "," + i + ") = " + SW_DynamicProg(i, i) + ", time is " + (System.currentTimeMillis() - startTimeDynamic) + " ms");
        }


    }
}
