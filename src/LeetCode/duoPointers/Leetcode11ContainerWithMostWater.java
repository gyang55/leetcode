package LeetCode.duoPointers;

public class Leetcode11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        //向内移动短板
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
