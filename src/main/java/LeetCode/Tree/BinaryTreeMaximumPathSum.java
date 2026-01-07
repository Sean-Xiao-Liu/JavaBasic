package LeetCode.Tree;

import DataStructure.TreeNode;

public class BinaryTreeMaximumPathSum {
    int result;

    public int maxSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        maxSumFromNode(root);
        return result;
    }

    public int maxSumFromNode(TreeNode node) {
        if (node == null) return 0;

        int leftTreeSum = Math.max(maxSumFromNode(node.left), 0);
        int rightTreeSum = Math.max(maxSumFromNode(node.right), 0);

        int sumOfPath = node.val + leftTreeSum + rightTreeSum;
        result = Math.max(result, sumOfPath);
        return node.val + Math.max(leftTreeSum, rightTreeSum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,new TreeNode(4),null);
        root.right = new TreeNode(3,null,new TreeNode(5));


        BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
        System.out.println(test.maxSum(root));
    }
}
