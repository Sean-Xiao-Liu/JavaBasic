package LeetCode;


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
        LeetCode.TreeNode root = new LeetCode.TreeNode(1); // the first node with value 1
        LeetCode.TreeNode left = new LeetCode.TreeNode(2);
        LeetCode.TreeNode right = new LeetCode.TreeNode(3);
        root.left = left; // connect the left node with the root node
        root.right = right;
        left.left = new LeetCode.TreeNode(4);
        left.right = new LeetCode.TreeNode(5);
        right.left = new LeetCode.TreeNode(6);
        right.right = new LeetCode.TreeNode(7);
        left.left.left = new LeetCode.TreeNode(8);
        left.left.right = new LeetCode.TreeNode(9);
        left.right.right = new LeetCode.TreeNode(10);
        right.right.left = new LeetCode.TreeNode(11);
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


        System.out.println(inorderTraversal3(root));

    }
}
