package LeetCode.recursive;

public class WeightsAndValuesIntoABag {
    //这个方法返回最大价值
    public static int process(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }

        if (i == weights.length) {
            return 0;
        }

        return Math.max(process(weights, values, i + 1, alreadyWeight, bag), values[i]
                + process(weights, values, i + 1, alreadyWeight + weights[i], bag));

    }


}
