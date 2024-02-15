package LeetCode.recursive;

public class Leetcode70ClimingStairs {
//    solution1 dynamic and LeetCode.recursive
//    private HashMap<Integer, Integer> stairMap = new HashMap<>();
//
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        if (null != stairMap.get(n)) {
//            return stairMap.get(n);
//        } else {
//            int result = climbStairs(n - 1) + climbStairs(n - 2);
//            stairMap.put(n, result);
//            return result;
//        }
//    }

    // nonrescursive
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            result = pre + prepre;
            prepre = pre;
            pre = result;


        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode70ClimingStairs leetcode70ClimingStairs = new Leetcode70ClimingStairs();
        System.out.println(leetcode70ClimingStairs.climbStairs(4));
    }
}
