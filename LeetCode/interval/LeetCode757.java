package interval;

import java.util.Arrays;

public class LeetCode757 {
    public int intersectionSizeTwo(int[][] intervals) {
        int max = -1;
        int secondMax = -1;
        int res = 0;
        //sort intervals by ascending order
        Arrays.sort(intervals, (interval1, interval2) -> (interval1[1] - interval2[1]));
        for (int[] interval:intervals
             ) {
            int start = interval[0];
            int end = interval[1];
            if (start>max){
                res+=2;
                secondMax = end - 1;
                max = end;
            } else if (start>secondMax) {
                res++;
                secondMax=max==end? max-1:max;
                max=end;
            }
        }
        return res;
    }
}
