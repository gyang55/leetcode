package greedy;

import java.util.*;

//class Node {
//
//    private String name;
//
//    private List<Node> shortestPath = new LinkedList<>();
//
//    private Integer distance = Integer.MAX_VALUE;
//
//    Map<Node, Integer> adjacentNodes = new HashMap<>();
//
//    public void addDestination(Node destination, int distance) {
//        adjacentNodes.put(destination, distance);
//    }
//
//    public Node(String name) {
//        this.name = name;
//    }
//
//    // getters and setters
//
//    public String getName() {
//        return name;
//    }
//
//    public void setDistance(Integer distance) {
//        this.distance = distance;
//    }
//
//    public Integer getDistance() {
//        return distance;
//    }
//
//    public List<Node> getShortestPath() {
//        return shortestPath;
//    }
//
//    public void setShortestPath(List<Node> shortestPath) {
//        this.shortestPath = shortestPath;
//    }
//
//    public Map<Node, Integer> getAdjacentNodes() {
//        return adjacentNodes;
//    }
//
//    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
//        this.adjacentNodes = adjacentNodes;
//    }
//}
//
//class Graph {
//    private Set<Node> nodes = new HashSet<>();
//
//    public void addNode(Node nodeA) {
//        nodes.add(nodeA);
//    }
//
//    public Set<Node> getNodes() {
//        return nodes;
//    }
//}

//public class Dijkstra {
//    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
//        source.setDistance(0);
//
//        Set<Node> settleNodes = new HashSet<>();
//        Set<Node> unsettledNodes = new HashSet<>();
//
//        unsettledNodes.add(source);
//
//        while (unsettledNodes.size() != 0) {
//            Node currentNode = getLowestDistanceNode(unsettledNodes);
//            unsettledNodes.remove(currentNode);
//            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()
//            ) {
//                Node adjacentNode = adjacencyPair.getKey();
//                Integer edgeWeight = adjacencyPair.getValue();
//                if (!settleNodes.contains(adjacentNode)) {
//                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
//                    unsettledNodes.add(adjacentNode);
//                }
//            }
//            settleNodes.add(currentNode);
//        }
//        return graph;
//    }
//
//    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
//        Node lowestDistanceNode = null;
//        int lowestDistance = Integer.MAX_VALUE;
//        for (Node node : unsettledNodes
//        ) {
//            int nodeDistance = node.getDistance();
//            if (nodeDistance < lowestDistance) {
//                lowestDistance = nodeDistance;
//                lowestDistanceNode = node;
//            }
//        }
//        return lowestDistanceNode;
//    }
//
//    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
//        Integer sourceDistance = sourceNode.getDistance();
//        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
//            evaluationNode.setDistance(sourceDistance + edgeWeigh);
//            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
//            shortestPath.add(sourceNode);
//            evaluationNode.setShortestPath(shortestPath);
//        }
//    }
//
//    public static void main(String[] args) {
//        Node nodeA = new Node("A");
//        Node nodeB = new Node("B");
//        Node nodeC = new Node("C");
//        Node nodeD = new Node("D");
//        Node nodeE = new Node("E");
//        Node nodeF = new Node("F");
//
//        nodeA.addDestination(nodeB, 10);
//        nodeA.addDestination(nodeC, 15);
//
//        nodeB.addDestination(nodeD, 12);
//        nodeB.addDestination(nodeF, 15);
//
//        nodeC.addDestination(nodeE, 10);
//
//        nodeD.addDestination(nodeE, 2);
//        nodeD.addDestination(nodeF, 1);
//
//        nodeF.addDestination(nodeE, 5);
//
//        Graph graph = new Graph();
//
//        graph.addNode(nodeA);
//        graph.addNode(nodeB);
//        graph.addNode(nodeC);
//        graph.addNode(nodeD);
//        graph.addNode(nodeE);
//        graph.addNode(nodeF);
//
//        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
//        for (Node node : graph.getNodes()
//        ) {
//            System.out.println(node.getName() + " " + node.getDistance());
//            System.out.println("Shortest path for " + node.getName());
//            for (Node nodeS : node.getShortestPath()
//            ) {
//
//                System.out.print(nodeS.getName() + " " + nodeS.getDistance());
//                System.out.println();
//            }
//            System.out.println();
//        }
//
//    }
//}
class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}

class Node {
    public int value;//??????
    public int in;//??????
    public int out;// ??????
    public ArrayList<Node> nexts;//????????????
    public ArrayList<Edge> edges;//

    public Node(int val) {
        value = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

class Edge {
    public int weight; //????????????
    public Node from;// ??????
    public Node to;//??????

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}

public class Dijkstra{
    public static HashMap<Node,Integer> newDijkstra(Node head,int size){//???hashmap??????????????????????????????????????????
        NodeHeap  nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head,0);//????????????add?????????????????????????????????update????????????????????????????????????ignore
        HashMap<Node,Integer> result = new HashMap<>();
        while(!nodeHeap.isEmpty()){
            NodeRecord record = nodeHeap.pop();
            Node cur =record.node;
            int distance = record.distance;
            for (Edge edge:cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to,edge.weight+distance);//?????????????????????????????????
            }
            result.put(cur,distance);
        }
        return result;
    }
    public static class NodeRecord{
        public Node node;
        public int distance;

        public NodeRecord(Node node,int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap{
        private Node[] nodes;
        private HashMap<Node,Integer> heapIndexMap;//??????????????????node?????????
        private HashMap<Node,Integer> distanceMap;//????????????????????????
        private int size;

        public NodeHeap(int size){
            nodes = new Node[size];//?????????nodes
            heapIndexMap =new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public void addOrUpdateOrIgnore(Node node,int distance){
            if(inHeap(node)){ //??????????????????
                distanceMap.put(node,Math.min(distance,distanceMap.get(node)));
                insertHeapify(node,heapIndexMap.get(node));
            }
            if(!isEntered(node)){//???????????????????????????????????????
                nodes[size] =node;
                heapIndexMap.put(node,size);
                distanceMap.put(node,distance);
                insertHeapify(node,size++);
            }

        }
        private boolean isEntered(Node node){//??????????????????
            return heapIndexMap.containsKey(node);
        }
        private  boolean inHeap(Node node){
            return isEntered(node)&&heapIndexMap.get(node)!=-1;//-1????????????????????????
        }
        private void swap(int index1,int index2){
            heapIndexMap.put(nodes[index1],index2);
            heapIndexMap.put(nodes[index2],index1);
            /*???heapIndexMap?????????nodes[index1]???[index2]?????????*/
            Node temp = nodes[index1];
            nodes[index1] =nodes[index2];
            nodes[index2]= temp;
        }
        public NodeRecord pop(){
            NodeRecord nodeRecord = new NodeRecord(nodes[0],distanceMap.get(nodes[0]));
            heapIndexMap.put(nodes[size-1],-1);
            distanceMap.remove(nodes[size-1]);
            nodes[size-1]=null;
            heapify(0,--size);
            return nodeRecord;
        }
        private void insertHeapify(Node node,int index){
            while(distanceMap.get(nodes[index])<distanceMap.get(nodes[(index-1)/2]));
            swap(index,(index-1)/2);
            index = (index-1)/2;
        }
        private void heapify(int index,int size){
            int left = index*2+1;
            while (left<size){
                int smallest = left+1<size&&distanceMap.get(nodes[left+1])<distanceMap.get(nodes[size])?
                        left+1:left;
                smallest = distanceMap.get(nodes[smallest])<distanceMap.get(nodes[index])?smallest:index;
                if(smallest==index){
                    break;
                }
            }
        }
    }
}
