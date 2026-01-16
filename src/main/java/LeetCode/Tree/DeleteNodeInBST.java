package LeetCode.Tree;

import DataStructure.TreeNode;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null || findNode(root, key) == null) return null;
        return root;
    }

    private TreeNode findNode(TreeNode node, int key) {
        if (node == null) return null;
        if (node.val == key) return node;
        if (key < node.val) return findNode(node.left, key);
        else return findNode(node.right, key);
    }


}
