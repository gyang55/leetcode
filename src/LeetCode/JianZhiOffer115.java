package LeetCode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class JianZhiOffer115 {
    /**
     * Topology
     */
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] inDegrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];
        //build directed edges
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int[] sequence : sequences
        ) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                int prev = sequence[i - 1];
                int next = sequence[i];
                if (graph[prev].add(next)) {
                    inDegrees[next]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            //There are more than one vertex whose in degrees are greater than 0, that means, the graph could be more than 1

            if (queue.size() > 1) {
                return false;
            }

            int temp = queue.poll();

            Set<Integer> set = graph[temp];

            for (int next : set
            ) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}
