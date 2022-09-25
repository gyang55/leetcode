package LeetCode.arrays;

public class JZ04 {
    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if(matrix.length==0||matrix[0].length==0){
                return false;
            }

            boolean flag = false;
            for (int i = 0; i < matrix.length; i++) {
                int length = matrix[i].length;
                if (target >=matrix[i][0] && target <= matrix[i][length - 1]) {
                    if (biSearch(matrix[i], target)) {
                        flag = true;
                    }
                }
                if (flag) {
                    return flag;
                }
            }
            return false;
        }

        private boolean biSearch(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] > target) {
                    right = mid - 1;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};

        int[][] arr = {{-5}};

        new JZ04().new Solution().findNumberIn2DArray(arr, -5);
    }
}
