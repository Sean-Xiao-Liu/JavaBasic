package LeetCode.Tree;

import DataStructure.TreeNode;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return false;
        // the difference of left and right sub tree should less or equal to 1 , and both sub tree should be balanced as well
        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int maxDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left) ,maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        /*
        *              1
        *             / \
        *            2   3
        *               / \
        *              4   5
        * */
        isBalanced(root);
    }
}
