package LeetCode.Tree;

import DataStructure.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        } else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,new TreeNode(4),null);
        root.right = new TreeNode(3,null,new TreeNode(5));


        InvertBinaryTree test = new InvertBinaryTree();
        TreeNode result =  test.invertTree(root);
        System.out.println(result);
    }
}
