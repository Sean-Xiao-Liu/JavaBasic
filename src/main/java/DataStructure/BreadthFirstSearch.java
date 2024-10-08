package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        BreadthFirstSearch test = new BreadthFirstSearch();
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
        test.largestValuesOfEachLayer(root);
        test.bfs(root);



    }

    public List<Integer> largestValuesOfEachLayer(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // notice the queue is a linked List
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) return result;

        queue.offer(root);
        while (!(queue.isEmpty())) { // while queue is not empty
            int temp = Integer.MIN_VALUE;
            int size = queue.size(); // number of nodes in each layer

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // pull the head of the queue
                if (node.val >= temp) {
                    temp = node.val;
                }
                // add the next layer to the queue
                if (!(node.left == null)) {
                    queue.offer(node.left);
                }
                if (!(node.right == null)) {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        System.out.println(result);
        return result;
    }

    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // notice the queue is a linked List
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) return result;

        queue.offer(root);
        while (!(queue.isEmpty())) { // while queue is not empty
            int size = queue.size(); // number of nodes in each layer, even the

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // pull the head of the queue
                result.add(node.val);
                // add the next layer to the queue
                if (!(node.left == null)) {
                    queue.offer(node.left);
                }
                if (!(node.right == null)) {
                    queue.offer(node.right);
                }
            }

        }
        System.out.println(result);
        return result;
    }
}
