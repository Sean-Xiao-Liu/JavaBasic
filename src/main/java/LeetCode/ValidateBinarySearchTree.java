package LeetCode;

import DataStructure.TreeNode;

public class ValidateBinarySearchTree {

    // focus on solve the root and use recursion to deal with left and right
    // also introduce additional arguments to record
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null, null);
    }


    public boolean isValidBST(TreeNode root,TreeNode min, TreeNode max){
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) // 对于左边的子节，最大的不能超过root
                && isValidBST(root.right, root, max); // 对于右边的子节，最小的不能小于root
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        ValidateBinarySearchTree test = new ValidateBinarySearchTree();
//        System.out.println(test.isValidBST(root));
        System.out.println(test.isValidBST(root2));
    }
}
