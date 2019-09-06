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
        /*
         *  the tree looks like:
         *             1
         *           /   \
         *          2     3
         *        /  \   /  \
         *       4    5 6    7
         * */
        test.largestValues(root);



    }

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        queue.offer(root);
        while (!(queue.isEmpty())) {
            int temp = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val >= temp) {
                    temp = node.val;
                }
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
}
