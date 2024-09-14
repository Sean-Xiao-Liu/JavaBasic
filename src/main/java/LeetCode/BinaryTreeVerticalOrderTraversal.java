package LeetCode;

import DataStructure.BreadthFirstSearch;
import DataStructure.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) { return new ArrayList<>(); }
        Map<Integer, List<Integer>> map = new TreeMap<>(); // key would be weight in sort order
        Map<TreeNode, Integer> weight = new HashMap<>(); // assign weight to each node
        Queue<TreeNode> queue = new LinkedList<>(); // need queue in bfs to track node in each layer

        queue.add(root);
        weight.put(root, 0);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int currWeight = weight.get(curr); // get weight of current node
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

    public List<List<Integer>> verticalOrderWithoutTreeMap(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        //use a HashMap to store the TreeNode and the according cloumn value
        Map<TreeNode, Integer> weight = new HashMap<TreeNode, Integer>();
        queue.offer(root);
        weight.put(root, 0);
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int w = weight.get(node);
            if (!map.containsKey(w)) {
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                weight.put(node.left, w - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                weight.put(node.right, w + 1);
            }
            //update min ,min means the minimum column value, which is the left most node
            min = Math.min(min, w);
        }
        while (map.containsKey(min)) {
            res.add(map.get(min++));
        }
        return res;
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
