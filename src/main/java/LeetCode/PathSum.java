package LeetCode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * */
public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {

        // boundary case
        if(root == null) return false;

        // subtract val from sum
        sum = sum - root.val;

        // check if reach the leaves already
        if(root.left == null && root.right == null) return (sum == 0);

        // sum has been updated already
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1); // the first node with value 1
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left; // connect the left node with the root node
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        left.left.left = new TreeNode(8);
        left.left.right = new TreeNode(9);
        left.right.right = new TreeNode(10);
        right.right.left = new TreeNode(11);
        /*
         *  the tree looks like:
         *             1
         *           /   \
         *          2     3
         *        /  \   /  \
         *       4    5 6    7
         *      / \    \    /
         *     8   9    10 11
         * */

        System.out.println(hasPathSum(root,16));
    }
}
