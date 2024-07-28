package LeetCode;


import DataStructure.TreeNode;

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

    public static List < Integer > inorderTraversal3(TreeNode root) {

        //避免输入的Node为空
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left);
            }
            answer.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right);
            }
        }
        return answer;
    }









    public static void main(String[] args) {

    }
}
