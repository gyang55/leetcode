import java.util.ArrayList;
import java.util.TreeSet;

/**
 * <p>
 * Graph builds graphs and performs DFS and TopoSort algorithm
 * </p>
 *
 * @author Guang Yang A01249847 set U
 */
public class Graph {
    /**
     * 　labels contains all the vertices of a graph
     */
    private final ArrayList<String> labels;

    /**
     * directed is a flag marking whether a graph is a directed or not
     */
    private final boolean directed;

    /**
     * graphRepresentation is a adjacency matrix represents a graph
     */
    private final int[][] graphRepresentation;

    /**
     * visited contains flags showing whether a vertex is visited or not. The indices of vertices are corresponding to
     * the indices of vertices in labels
     */
    private ArrayList<Boolean> visited;

    /**
     * <p>
     * The Graph constructor
     * </p>
     *
     * @param labels,  the arraylist of vertices
     * @param directed boolean, whether the graph is directed
     */
    public Graph(ArrayList<String> labels, boolean directed) {
        this.labels = labels;
        this.directed = directed;
        graphRepresentation = new int[labels.size()][labels.size()];
    }


    /**
     * <p>
     * Add edge between two vertices to the adjacency matrix
     * </p>
     *
     * @param vertex1, LeetCode.String
     * @param vertex2  LeetCode.String
     */
    private void AddEdge(String vertex1, String vertex2) {
        int indexOfVertex1 = labels.indexOf(vertex1);
        int indexOfVertex2 = labels.indexOf(vertex2);
        if (isDirected()) {
            graphRepresentation[indexOfVertex1][indexOfVertex2] = 1;
        } else {
            graphRepresentation[indexOfVertex1][indexOfVertex2] = 1;
            graphRepresentation[indexOfVertex2][indexOfVertex1] = 1;
        }
    }

    /**
     * <p>
     * Get the labels size
     * </p>
     */
    private int size() {
        return labels.size();
    }

    /**
     * <p>
     * Getter of class variable directed
     * </p>
     */
    private boolean isDirected() {
        return this.directed;
    }

    /**
     * <p>
     * Get the a certain vertex in the labels
     * </p>
     *
     * @param index, int, the index of the vertex
     */
    private String getVertex(int index) {
        return labels.get(index);
    }

    /**
     * <p>
     * Print out the graph's adjacency matrix and return it
     * </p>
     *
     * @return graphRepresentation, 2D int array, the adjacency matrix
     */
    private int[][] adjMatrix() {
        return this.graphRepresentation;
    }

    /**
     * <p>
     * Use DFS algorithm to get the visited order
     * </p>
     *
     * @param start,LeetCode.String, the first vertex to visit
     * @return DFSOrder, Arraylist
     */
    public ArrayList<String> getDFSOrder(String start) {
        ArrayList<String> DFSOrder = new ArrayList<>();
        visited = new ArrayList<>(size());
        for (int i = 0; i < size(); i++) {
            visited.add(false);
        }
        dfs_helper(start, DFSOrder);
        return DFSOrder;
    }

    /**
     * <p>
     * DFS helper function
     * </p>
     *
     * @param vertex,LeetCode.String, the next vertex to visit
     * @param DFSOrder,      ArrayList, the dfs visited order
     */
    private void dfs_helper(String vertex, ArrayList<String> DFSOrder) {
        int index = labels.indexOf(vertex);
        visited.set(index, true);
        DFSOrder.add(vertex);
        for (int i = 0; i < size(); i++) {
            //int edge = graphRepresentation[index][i];
            int edge = adjMatrix()[index][i];
            boolean neighbourVisited = visited.get(i);
            if (edge == 1 && !neighbourVisited) {
                dfs_helper(getVertex(i), DFSOrder);
            }
        }
    }

    /**
     * <p>
     * Get TopologicalOrder
     * </p>
     *
     * @param start,LeetCode.String, the first vertex to visit
     * @return topologicalSortOrder, ArrayList, the topologicalSortOrder visited order
     */
    public ArrayList<String> getTopologicalOrder(String start) {
        ArrayList<String> topologicalSortOrder = new ArrayList<>();
        TreeSet<String> candidates = new TreeSet<>();
        // Check if the vertex's in-degree  is 0, if true, add it to the candidates.
        if (checkInDegree(labels.indexOf(start))) {
            candidates.add(start);
        }
        // Check all the vertices in the labels and add all vertices whose in-degree is 0 to the candidates
        addCandidates(candidates);
        while (!candidates.isEmpty()) {
            start = candidates.first();
            topologicalSortOrder.add(start);
            int index = labels.indexOf(start);
            /* Remove edge is a neighbour vertex is visited and check if the in-degree of that vertex is 0. Add to
            candidates the in-degree is 0*/
            for (int i = 0; i < size(); i++) {
                if (graphRepresentation[index][i] == 1) {
                    graphRepresentation[index][i] = 0;
                    if (checkInDegree(i)) {
                        candidates.add(labels.get(i));
                    }
                }
            }
            candidates.remove(start);
        }
        return topologicalSortOrder;
    }

    /**
     * <p>
     * Iterate through the labels, and add all vertices in the label whose in-degree is 0 to the candidates.
     * </p>
     *
     * @param candidates,TreeSet, the set of candidates to be checked
     */
    private void addCandidates(TreeSet<String> candidates) {
        for (int i = 0; i < size(); i++) {
            int inDegree = 0;
            for (int j = 0; j < size(); j++) {
                if (graphRepresentation[j][i] == 0) {
                    inDegree++;
                }
            }
            String vertex = labels.get(i);
            if (inDegree == size()) {
                candidates.add(vertex);
            }
        }
    }

    /**
     * <p>
     * Check the in-degree of a certain vertex
     * </p>
     *
     * @param index,int, the index of the vertex to be checked
     */
    private boolean checkInDegree(int index) {
        int inDegree = 0;
        for (int i = 0; i < size(); i++) {
            if (graphRepresentation[i][index] == 0) {
                inDegree++;
            }
        }
        return inDegree == size();
    }

    /**
     * <p>
     * Return a LeetCode.String represent the graph
     * </p>
     *
     * @return representation.toString(), LeetCode.String, the representation of the graph ready for printing
     */
    public String toString() {
        StringBuilder representation = new StringBuilder();
        representation.append("The adjacency matrix of the graph is\n");
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                String edgeRepresentation = graphRepresentation[i][j] + " ";
                representation.append(edgeRepresentation);
            }
            representation.append("\n");
        }
        return representation.toString();
    }

    public static void main(String[] args) {
        // DFS test case 1 undirected graph
        ArrayList<String> vertices1 = new ArrayList<>();
        for (int i = 97; i < 105; i++) {
            char ver = (char) i;
            vertices1.add(Character.toString(ver));
        }
        Graph graph = new Graph(vertices1, false);
        graph.AddEdge("a", "b");
        graph.AddEdge("a", "f");
        graph.AddEdge("a", "e");
        graph.AddEdge("b", "f");
        graph.AddEdge("b", "g");
        graph.AddEdge("f", "e");
        graph.AddEdge("g", "c");
        graph.AddEdge("g", "h");
        graph.AddEdge("c", "d");
        graph.AddEdge("d", "h");
        System.out.println(graph);
        ArrayList<String> results = graph.getDFSOrder("a");
        System.out.println("The DFS order is:");
        for (String vertex : results
        ) {
            System.out.print(vertex + " ");
        }
        System.out.println();
        System.out.println();

        //DFS test case 2 undirected graph
        ArrayList<String> vertices2 = new ArrayList<>();
        vertices2.add("a0");
        vertices2.add("a1");
        vertices2.add("a2");
        vertices2.add("a3");
        vertices2.add("a4");
        Graph graph2 = new Graph(vertices2, false);
        graph2.AddEdge("a0", "a1");
        graph2.AddEdge("a0", "a4");
        graph2.AddEdge("a0", "a3");
        graph2.AddEdge("a4", "a1");
        graph2.AddEdge("a4", "a3");
        graph2.AddEdge("a1", "a2");
        graph2.AddEdge("a2", "a3");
        System.out.println(graph2);
        ArrayList<String> results2 = graph2.getDFSOrder("a0");
        System.out.println("The DFS order is:");
        for (String vertex2 : results2
        ) {
            System.out.print(vertex2 + " ");
        }
        System.out.println();
        System.out.println();

        // test case 3 directed graph
        ArrayList<String> vertices3 = new ArrayList<>();
        for (int i = 97; i < 103; i++) {
            char ver = (char) i;
            vertices3.add(Character.toString(ver));
        }
        Graph graph3 = new Graph(vertices3, true);
        graph3.AddEdge("a", "b");
        graph3.AddEdge("a", "f");
        graph3.AddEdge("a", "e");
        graph3.AddEdge("b", "c");
        graph3.AddEdge("f", "e");
        graph3.AddEdge("e", "d");
        graph3.AddEdge("d", "b");
        graph3.AddEdge("d", "c");
        System.out.println(graph3);
        ArrayList<String> results3 = graph3.getDFSOrder("a");
        System.out.println("The DFS order is:");
        for (String vertex3 : results3
        ) {
            System.out.print(vertex3 + " ");
        }

        System.out.println();
        ArrayList<String> result4 = graph3.getTopologicalOrder("a");
        System.out.println("The topological order is:");
        for (String vertex4 : result4
        ) {
            System.out.print(vertex4 + " ");
        }
        System.out.println();
        System.out.println();
    }
}

