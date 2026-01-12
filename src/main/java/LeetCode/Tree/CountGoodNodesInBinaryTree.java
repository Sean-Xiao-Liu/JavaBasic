package LeetCode.Tree;

import DataStructure.TreeNode;
import Utils.BinaryTreeConstructor;
/** 
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 * Example 1:
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Example 2:
 * Input: root = [3,3,null,4,2]
 * Output: 3
 */
public class CountGoodNodesInBinaryTree {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val); // start the dfs from the root node
        return count;
    }

    private void dfs(TreeNode node, int maxVal) {
        if(node == null) return; // if the node is null, return
        if(node.val >= maxVal) { // if the node is a good node, increment the count
            count++;
            maxVal = node.val; // update the maxVal to the node's value
        }
        dfs(node.left, maxVal); // traverse the left subtree
        dfs(node.right, maxVal); // traverse the right subtree
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeConstructor.buildTree(new Integer[]{3,1,4,3,null,1,5});
        BinaryTreeConstructor.printTree(root);
        System.out.println(new CountGoodNodesInBinaryTree().goodNodes(root));
    }
}
