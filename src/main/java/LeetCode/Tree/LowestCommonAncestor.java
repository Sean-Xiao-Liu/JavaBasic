package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;  
import Utils.BinaryTreeConstructor;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = findAncestor(root, p, new ArrayList<>());
        List<TreeNode> qAncestors = findAncestor(root, q, new ArrayList<>());
        // if the node has no ancestors, means the ancestor is the root node
        // if(pAncestors.size() == 0 || qAncestors.size() == 0) return root;
        int length = Math.min(pAncestors.size(), qAncestors.size());
        for(int i = 0; i < length; i++) {
            if(pAncestors.get(i).val != qAncestors.get(i).val) {
                return pAncestors.get(i - 1);
            }
        }
        return pAncestors.get(length - 1);
    }

    public List<TreeNode> findAncestor(TreeNode root, TreeNode p, List<TreeNode> ancestors) {
        findAncestorHelper(root, p, ancestors);
        return ancestors;
    }
    
    // Helper method that returns true if target is found in subtree
    // the boolean return value is used to determine if the target is found in the subtree
    private boolean findAncestorHelper(TreeNode root, TreeNode target, List<TreeNode> ancestors) {
        if (root == null) return false;
        
        // If we found the target node
        // add the node to the ancestors list and return true
        if (root.val == target.val) {
            ancestors.add(root);
            return true;
        }
        
        // Add current node as potential ancestor
        ancestors.add(root);
        
        // Search in left subtree
        if (findAncestorHelper(root.left, target, ancestors)) {
            return true;
        }
        
        // Search in right subtree
        if (findAncestorHelper(root.right, target, ancestors)) {
            return true;
        }
        
        // Target not found in either subtree, backtrack
        ancestors.remove(ancestors.size() - 1);
        return false;
    }


    public TreeNode backtrack(TreeNode root, TreeNode p, TreeNode q) {
        
        // the line below is the most hard to understand
        // for the first level recursion, if p(or q) is exactly the whole tree's root, 
        // return the root(because root is the lowest node).
        // for deeper(higher nodes) recursions, it indicates:
        // (1) we find p(or q), which is fine because this node will not be returned(to output) 
        // instantly since it belongs to a deeper recursion but will be used for 
        // determinations of shallower(lower nodes) recursions
        // (2) we reach the bottom of the tree, terminate the current track instantly 
        // and "null" will also be used for shallower recursions' determine statements.
        if (root == null || root == p || root == q)
            return root;
        
        TreeNode left = backtrack(root.left, p, q);
        TreeNode right = backtrack(root.right, p, q);
        
        // determine statements
        
        if (left != null && right != null) // which means p,q exist below different subtrees;
            return root;
        
        return left != null ? left : right; // which means p,q exist below the same subtree;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeConstructor.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        BinaryTreeConstructor.printTree(root);  
        System.out.println(new LowestCommonAncestor().findAncestor(root, new TreeNode(3), new ArrayList<>()));
        System.out.println(new LowestCommonAncestor().findAncestor(root, new TreeNode(4), new ArrayList<>()));
    }
}
