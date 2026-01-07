package LeetCode.Tree;


import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size(); // get size of current queue, which determine the poll times
            List<Integer> temp = new ArrayList<>();

            // iterate through the queue and add all numbers of current layer to list
            for(int i = 0; i < size ; i++){
                 TreeNode node = queue.poll();
                 temp.add(node.val); /** operation on each */


                // add the next layer to the queue
                if (!(node.left == null)) {
                    queue.offer(node.left);
                }
                if (!(node.right == null)) {
                    queue.offer(node.right);
                }
            }
            result.add(new ArrayList<>(temp)); // put add operation here to prevent duplicate in the temp
        }

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
         *  the tree looks like:
         *             1
         *           /   \
         *          2     3
         *        /  \   /  \
         *       4    5 6    7
         *      / \    \    /
         *     8   9    10 11
         * */

        System.out.println(levelOrder(root));
    }
}
