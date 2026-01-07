package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    /** method 1*/
    private static List<Integer> listRight = new ArrayList<>();
    private static List<Integer> listLeft = new ArrayList<>();

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        preOrderDFSLeft(root);
        preOrderDFSRight(root);
        System.out.println(listLeft);
        System.out.println(listRight);
        return listLeft.equals(listRight); // the 2 branch should be the same if the tree is symmetric
    }

    private static void preOrderDFSLeft(TreeNode root){
        if(root != null){
            listLeft.add(root.val);
        } else {
            return;
        }
        if (root.left != null){ // left branch comes first
            preOrderDFSLeft(root.left);
        } else {
            listLeft.add(null);
        }
        if (root.right != null){
            preOrderDFSLeft(root.right);
        } else {
            listLeft.add(null);
        }
    }

    private static void preOrderDFSRight(TreeNode root){
        if(root != null){
            listRight.add(root.val);
        } else {
            return;
        }
        if (root.right != null){ // right branch comes first
            preOrderDFSRight(root.right);
        } else {
            listRight.add(null);
        }
        if (root.left != null) {
            preOrderDFSRight(root.left);
        } else {
            listRight.add(null);
        }
    }

    /** method 2 recursive*/
    public static boolean isSymmetric2(TreeNode root) {
        return isMirror(root,root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false; // if only one of the node is null it means the tree is not symmetric
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    /** method 3 general tree frame**/
    // https://github.com/Sean-Xiao-Liu/fucking-algorithm/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E6%93%8D%E4%BD%9C%E9%9B%86%E9%94%A6.md
    public boolean isSymmetric3(TreeNode root) {
        return isMirror3(root,root);
    }

    private static boolean isMirror3(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        // return (t1.val == t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
        if(t1.val != t2.val) return false;
        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
        /*           1
                    / \
                   2   2
                  / \ / \
                 3  4 4  3
        * */
        System.out.println(isSymmetric(root));
    }
}
