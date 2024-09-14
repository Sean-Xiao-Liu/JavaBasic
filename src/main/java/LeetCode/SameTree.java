package LeetCode;

import DataStructure.TreeNode;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) return false;

        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        p.left = null;
        p.right = new TreeNode(2);
        q.left = new TreeNode(2);
        System.out.println(isSameTree(p,q));

    }
}
