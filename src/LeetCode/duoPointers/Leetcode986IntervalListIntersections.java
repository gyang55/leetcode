package LeetCode.duoPointers;

import java.util.ArrayList;
import java.util.List;

public class Leetcode986IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }
        int firstPointer = 0;
        int secondPointer = 0;
        while (firstPointer < firstList.length && secondPointer < secondList.length) {
            int interStart = Math.max(firstList[firstPointer][0], secondList[secondPointer][0]);
            int interEnd = Math.min(firstList[firstPointer][1], secondList[secondPointer][1]);
            if (interStart <= interEnd) {
                ans.add(new int[]{interStart, interEnd});
            }

            //Remove the interval with the smallest endpoint
            if (firstList[firstPointer][1] < secondList[secondPointer][1]) {
                firstPointer++;
            } else {
                secondPointer++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
