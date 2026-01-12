package LeetCode.Tree;

import DataStructure.TreeNode;
import Utils.BinaryTreeConstructor;
import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    List<Integer> leaves1 = new ArrayList<>();
    List<Integer> leaves2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        preOrderDFS(root1, leaves1);
        preOrderDFS(root2, leaves2); 
        System.out.println("leaves1: " + leaves1);
        System.out.println("leaves2: " + leaves2);
        return leaves1.equals(leaves2);
    }

    private void preOrderDFS(TreeNode root, List<Integer> leaves) {
        if(root == null) return; // base case and also a stopping condition
        if(root.left == null && root.right == null) { // if the node is a leaf node, add the value to the list
            leaves.add(root.val);
        }
        if(root.left != null) preOrderDFS(root.left, leaves); // if the left child is not null, traverse the left subtree
        if(root.right != null) preOrderDFS(root.right, leaves); // if the right child is not null, traverse the right subtree
    }

    public static void main(String[] args) {
        TreeNode root1 = BinaryTreeConstructor.buildTree(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        TreeNode root2 = BinaryTreeConstructor.buildTree(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});
        // System.out.println(new LeafSimilarTrees().leafSimilar(root1, root2));
        BinaryTreeConstructor.printTree(root1);
        BinaryTreeConstructor.printTree(root2);
        new LeafSimilarTrees().leafSimilar(root1, root2);
        // System.out.println(leaves1);
        // System.out.println(leaves2);
    }
}
