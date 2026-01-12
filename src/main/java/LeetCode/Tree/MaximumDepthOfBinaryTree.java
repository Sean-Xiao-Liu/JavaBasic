package LeetCode.Tree;

import DataStructure.Queue;
import DataStructure.TreeNode;

import java.util.LinkedList;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // the 1 is the root node and the max is the max depth of the left and right sub tree
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.push(root);

        while (!queue.isEmpty()) {
            // get number of nodes in current level
            int levelSize = queue.size();
            count++;

            // only process certain number of node, which is the levelSize
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,new TreeNode(4),null);
        root.right = new TreeNode(3,null,new TreeNode(5));


        MaximumDepthOfBinaryTree test = new MaximumDepthOfBinaryTree();
        System.out.println(test.maxDepth2(root));
    }
}
