package LeetCode.DFSBFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode574NumOfProvinces {
    /**
     * BFS
     * */
//    public int findCircleNum(int[][] isConnected) {
//        int cities = isConnected.length;
//        int res = 0;
//        boolean[] visited = new boolean[cities];
//        Deque<Integer> integerDeque = new ArrayDeque<>();
//        for (int i = 0; i < cities; i++) {
//            if (!visited[i]) {
//                integerDeque.offer(i);
//                while (!integerDeque.isEmpty()) {
//                    int j = integerDeque.poll();
//                    visited[j] = true;
//                    for (int k = 0; k < cities; k++) {
//                        if (isConnected[j][k] == 1 && !visited[k]) {
//                            integerDeque.offer(k);
//                        }
//                    }
//                }
//                res++;
//            }
//        }
//        return res;
//    }

    /**
     * DFS
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }
}
