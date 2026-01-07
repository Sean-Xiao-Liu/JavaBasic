package LeetCode.Tree;

//import DataStructure.TreeNode;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SubtreeOfAnotherTree {
//    public static boolean isSubtree(TreeNode s, TreeNode t) {
//        String stringS = preorder(s,true);
//        String stringT = preorder(t,true);
//        return stringS.indexOf(stringT) >= 0;
//    }
//
//    // use recursive method to distinguish the null value on the left and right null
//    public static String preorder(TreeNode t, boolean left) {
//        if (t == null) {
//            if (left)
//                return "lnull";
//            else
//                return "rnull";
//        }
//        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
//    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            if (node.val == subRoot.val) {
//                if(containsSubTree(node,subRoot)) return true;
//            }
//
//            if (node.left != null) queue.offer(node.left);
//            if (node.right!= null) queue.offer(node.right);
//        }
//        return false;

        if(root==null){
            return false;
        }

        if(root.val==subRoot.val){
            if(containsSubTree(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    public boolean containsSubTree(TreeNode node, TreeNode subNode){
        if ((node == null && subNode != null) || (subNode == null && node != null)) return false;

        if (node == null && subNode == null) {
            return true;
        }

        if (node.val != subNode.val) {
            return false;
        }
        return containsSubTree(node.left, subNode.left) && containsSubTree(node.right, subNode.right);
    }


    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right =  new TreeNode(2);
        s.left.right.left =  new TreeNode(0);


        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();

        System.out.println(subtreeOfAnotherTree.isSubtree(s,t));
//        System.out.println(preorder(s,true));
//        System.out.println(preorder(t,true));
    }

}

//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int val){
//        this.val = val;
//    }
//}