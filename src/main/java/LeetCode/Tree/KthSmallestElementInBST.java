package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.*;

public class KthSmallestElementInBST {
    // this method doesn't put BST into consideration
//    public int kthSmallest(TreeNode root, int k) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        LinkedList<TreeNode> nodes = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            nodes.add(node);
//            if (node.left != null) queue.offer(node.left);
//            if (node.right != null) queue.offer(node.right);
//        }
//
//        Collections.sort(nodes, Comparator.comparingInt(node -> node.val));
//        return nodes.get(k - 1).val;
//    }
//
//    // the second method needs to read the whole tree, which is not necessary
//    public int kthSmallest2(TreeNode root, int k) {
//        inorderTraversal(root);
//        return answer.get(k-1);
//    }
//
//    private List<Integer> answer = new ArrayList<>();
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root == null) return answer;
//        if(root.left != null) inorderTraversal(root.left);
//        if(root != null){
//            answer.add(root.val);
//        }
//        if(root.right!=null) inorderTraversal(root.right);
//        return answer;
//    }
//
//    public int kthSmallest3(TreeNode root, int k) {
//        inorderTraversal2(root,k);
//        return answer.get(k-1);
//    }
//
//    public List<Integer> inorderTraversal2(TreeNode root, int count) {
//        if(root == null) return answer;
//        if(root.left != null) inorderTraversal2(root.left,count);
//        if(root != null){
//            answer.add(root.val);
//            if(answer.size() == count) return answer;
//        }
//        if(root.right!=null) inorderTraversal2(root.right,count);
//        return answer;
//    }

    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    // use void method and return nothing instead of using arraylist
    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(node.left, k);

        // Visit the root node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k);
    }

}
