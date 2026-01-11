package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
            if(root.left != null) postorderTraversal(root.left);
            if(root.right != null) postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }


    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) return result;
        if (root.left != null) postorderTraversal2(root.left);
        if (root.right != null) postorderTraversal2(root.right);
        result.add(root.val);
        return result;
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
         * the tree looks like:
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * / \ \ /
         * 8 9 10 11
         */

        BinaryTreePostorderTraversal test = new BinaryTreePostorderTraversal();
        System.out.println(test.postorderTraversal(root));

    }
}
