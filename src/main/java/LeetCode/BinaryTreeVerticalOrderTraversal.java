package LeetCode;

import DataStructure.BreadthFirstSearch;
import DataStructure.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) { return new ArrayList<>(); }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Map<TreeNode, Integer> weight = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        weight.put(root, 0);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int currWeight = weight.get(curr);
            map.computeIfAbsent(currWeight, pos -> new ArrayList<>()).add(curr.val);

            if (curr.left != null) {
                queue.add(curr.left);
                weight.put(curr.left, currWeight - 1);
            }

            if (curr.right != null) {
                queue.add(curr.right);
                weight.put(curr.right, currWeight + 1);
            }
        }

        return  new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal test = new BinaryTreeVerticalOrderTraversal();
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

        System.out.println(test.verticalOrder(root));



    }
}
