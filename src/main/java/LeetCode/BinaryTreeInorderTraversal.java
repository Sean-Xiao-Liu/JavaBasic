package LeetCode;

import DataStructure.TreeNode;
;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return answer;

        if(root.left != null) inorderTraversal(root.left);
        if(root != null){
            answer.add(root.val);
        }
        if(root.right!=null) inorderTraversal(root.right);
        return answer;
    }

    private static List<Integer> answer = new ArrayList<>();

    public static List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }











    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);

        System.out.println(inorderTraversal(root) );
        System.out.println(inorderTraversal2(root));

    }
}
