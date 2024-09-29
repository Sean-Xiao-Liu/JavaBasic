package LeetCode;

import DataStructure.Node;

import java.util.*;

public class CloneGraph {
//    Map<Integer, List<Node>> map;
//
//    public Node cloneGraph(Node node) {
//        // start with edge cases
//        if (node == null) return null;
//        if (node.neighbors.isEmpty()) return new Node(node.val);
//        map = new TreeMap<>();
//        helper(node);
//        List<Node> generatedNodes = new LinkedList<>();
//        for(int i:map.keySet()){
//            Node generatedNode = new Node(i,new ArrayList<>());
//            generatedNodes.add(generatedNode);
//        }
//
//
//        for(Node g:generatedNodes){
//            for(Node n: map.get(g.val)){
//                g.neighbors.add(generatedNodes.get(n.val-1));
//            }
//        }
//
//        return generatedNodes.get(0);
//    }
//
//    private void helper(Node node){
//        if (map.containsKey(node.val)) return;
//
//        map.put(node.val, node.neighbors);
//
//        for(Node n: node.neighbors){
//            helper(n);
//        }
//    }


    public Node cloneGraph(Node node) {
        // Handle edge cases
        if (node == null) return null;

        // Use a map to keep track of new nodes that are generated based on their integer value
        Map<Integer, Node> newNodes = new HashMap<>();

        // Start cloning the graph by visiting nodes recursively
        return cloneNode(node, newNodes);
    }

    private Node cloneNode(Node node, Map<Integer, Node> newNodes) {
        // If this node has already been cloned, return the clone
        if (newNodes.containsKey(node.val)) {
            return newNodes.get(node.val);
        }

        // Create a new node with the same value as the original node
        Node clone = new Node(node.val, new ArrayList<>());

        // Store the clone in the map based on its value
        newNodes.put(clone.val, clone);

        // Recursively clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneNode(neighbor, newNodes));
        }

        return clone;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.neighbors = new ArrayList<>();
        one.neighbors.add(two);
        one.neighbors.add(three);
        two.neighbors = new ArrayList<>();
        two.neighbors.add(one);
        two.neighbors.add(three);
        three.neighbors = new ArrayList<>();
        three.neighbors.add(two);
        three.neighbors.add(one);

        CloneGraph c = new CloneGraph();
        c.cloneGraph(one);

    }
}
