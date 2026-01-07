package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import DataStructure.Node;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Node> map = new HashMap<>();
        for(int i = 0 ; i < numCourses ; i++){
            map.put(i, new Node(i));
        }

        for(int i = 0 ; i < prerequisites.length ;i++){
            map.get(prerequisites[i][0])
                    .neighbors
                    .add(map.get(prerequisites[i][1]));
            if(map.get(prerequisites[i][0])==map.get(prerequisites[i][1])) return false;
        }
        return hasCycle(map.get(0));

    }

    public boolean hasCycle(Node node) {
        Set<Node> visited = new HashSet<>();
        Set<Node> recursionStack = new HashSet<>();

        return dfs(node, visited, recursionStack);
    }

    private boolean dfs(Node node, Set<Node> visited, Set<Node> recursionStack) {
        if (recursionStack.contains(node)) {
            // Node is in the recursion stack, so we found a cycle
            return true;
        }
        if (visited.contains(node)) {
            // Node has already been visited and fully explored, so skip it
            return false;
        }

        // Mark node as visited and add it to the recursion stack
        visited.add(node);
        recursionStack.add(node);

        // Visit all neighbors (outgoing edges)
        for (Node neighbor : node.neighbors) {
            if (dfs(neighbor, visited, recursionStack)) {
                return true;
            }
        }

        // Remove the node from the recursion stack before returning
        recursionStack.remove(node);
        return false;
    }
}
