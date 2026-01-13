package LeetCode.Tree;

import DataStructure.TreeNode;
import Utils.BinaryTreeConstructor;
import java.util.Queue;
import java.util.LinkedList;

public class MaximumLevelSum {
    public int maxLevelSum(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int answer = 1;
        int level = 1;
        int maxLevelSum = Integer.MIN_VALUE;

        while (queue.size() != 0) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (levelSum > maxLevelSum){
                answer = level;
                maxLevelSum = levelSum;
            }
            level++;
        }

        return answer;
    }

    /**
     * Optimized version of maxLevelSum using BFS (Level Order Traversal)
     * 
     * OPTIMIZATIONS:
     * 1. Removed unnecessary leaf node check - simplifies logic
     * 2. Initialize maxLevelSum with root value to reduce comparisons
     * 3. Use isEmpty() instead of size() != 0 (more idiomatic Java)
     * 4. Cleaner null check pattern
     * 
     * ALGORITHM:
     * - Use BFS to traverse tree level by level
     * - Track sum of each level and compare with max found so far
     * - Return the smallest level number with maximum sum
     * 
     * TIME COMPLEXITY: O(n) where n is number of nodes (visit each node once)
     * SPACE COMPLEXITY: O(w) where w is max width of tree (queue size)
     * 
     * @param root - root of binary tree
     * @return smallest level number (1-indexed) with maximum sum
     */
    public int maxLevelSum2(TreeNode root) {
        // Base case: null tree or single node returns level 1
        if (root == null) return 1;
        
        // Initialize BFS queue with root node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // Track the level with maximum sum (answer to return)
        int maxLevel = 1;
        // Track the current level being processed (1-indexed)
        int currentLevel = 1;
        // Initialize max sum with root's value (optimization: avoids first comparison)
        int maxSum = root.val;
        
        // Process tree level by level using BFS
        while (!queue.isEmpty()) {
            // Number of nodes at current level
            int levelSize = queue.size();
            // Sum of all node values at current level
            int levelSum = 0;
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                
                // Add children to queue for next level processing
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            // Update answer if current level has strictly greater sum
            // Note: We use > (not >=) to ensure we return the SMALLEST level number
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }
            
            // Move to next level
            currentLevel++;
        }
        
        return maxLevel;
    }

    public static void main(String[] args) {
        // Test case: [1,7,0,7,-8,null,null]
        //       1
        //     /   \
        //    7     0
        //   / \
        //  7  -8
        // Level 1: 1
        // Level 2: 7 + 0 = 7
        // Level 3: 7 + (-8) = -1
        // Expected output: 2 (level with max sum)
        
        TreeNode root = BinaryTreeConstructor.buildTree(new Integer[]{1, 7, 0, 7, -8});
        BinaryTreeConstructor.printTree(root);
        
        MaximumLevelSum solution = new MaximumLevelSum();
        
        System.out.println("Original method result: " + solution.maxLevelSum(root));
        System.out.println("Optimized method result: " + solution.maxLevelSum2(root));
        
        // Test case 2: Single node
        TreeNode root2 = BinaryTreeConstructor.buildTree(new Integer[]{5});
        System.out.println("\nSingle node test:");
        System.out.println("Original: " + solution.maxLevelSum(root2));
        System.out.println("Optimized: " + solution.maxLevelSum2(root2));
    }
}
