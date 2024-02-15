package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MostProfitWithCost {
    public static class Project {
        public int cost;
        public int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static class minCostComparator implements Comparator<Project> {

        @Override
        public int compare(Project o1, Project o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class maxProfitComparator implements Comparator<Project> {

        @Override
        public int compare(Project o1, Project o2) {
            return o2.profit - o1.profit;
        }
    }

    public static int findMaximizedCapital(int maxNumOfProjects, int initialCost, int[] profits, int[] capital) {
        PriorityQueue<Project> minCostQ = new PriorityQueue<>(new minCostComparator());
        PriorityQueue<Project> maxProfitQ = new PriorityQueue<>(new maxProfitComparator());

        for (int i = 0; i < profits.length; i++) {
            minCostQ.add(new Project(capital[i], profits[i]));
        }

        for (int i = 0; i < maxNumOfProjects; i++) {
                maxProfitQ.add(maxProfitQ.poll());
            }
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= initialCost) {
            if (maxProfitQ.isEmpty()) {
                return initialCost;
            }
            initialCost += maxProfitQ.poll().profit;
        }
        return initialCost;
    }
}
