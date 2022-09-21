package LeetCode.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode733FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

            helper(image, sr, sc, newColor, image[sr][sc]);

            return image;

        }

        void helper(int[][] image, int sr, int sc, int newColor, int oldColor) {

            if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                    || image[sr][sc] != oldColor || newColor == oldColor){
                return;
            }

            image[sr][sc] = newColor;

            helper(image, sr - 1, sc, newColor, oldColor);
            helper(image, sr + 1, sc, newColor, oldColor);
            helper(image, sr, sc - 1, newColor, oldColor);
            helper(image, sr, sc + 1, newColor, oldColor);

        }
    }

}
