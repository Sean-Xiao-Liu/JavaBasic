package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = new ArrayList<>();
        List<TreeNode> qAncestors = new ArrayList<>();
        findAncestors(root,p.val,pAncestors);
        findAncestors(root,q.val,qAncestors);
        return findLastCommonNode(pAncestors,qAncestors);
    }

    private boolean findAncestors(TreeNode node, int target, List<TreeNode> ancestors) {
        if (node == null) {
            return false;
        }

        // Add the current node to the list of ancestors
        ancestors.add(node);

        // If the current node is the target node, return true
        if (node.val == target) {
            return true;
        }

        // If target is smaller, search in the left subtree
        if (target < node.val) {
            if (findAncestors(node.left, target, ancestors)) {
                return true;
            }
        }
        // If target is larger, search in the right subtree
        else {
            if (findAncestors(node.right, target, ancestors)) {
                return true;
            }
        }

        // If target is not found in either subtree, remove the node from the list
        ancestors.remove(ancestors.size() - 1);
        return false;
    }

    public TreeNode findLastCommonNode(List<TreeNode> path1, List<TreeNode> path2) {
        int len1 = path1.size();
        int len2 = path2.size();

        // Keep track of the last common node
        TreeNode lastCommonNode = null;

        // Traverse both lists from the beginning
        for (int i = 0; i < Math.min(len1, len2); i++) {
            // If the nodes are the same, update the lastCommonNode
            if (path1.get(i) == path2.get(i)) {
                lastCommonNode = path1.get(i);
            } else {
                // Break when the nodes start to differ
                break;
            }
        }

        return lastCommonNode;
    }


    public static void main(String[] args) {
        LowestCommonAncestorOfBST l = new LowestCommonAncestorOfBST();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        System.out.println(l.lowestCommonAncestor(root,root.left,root.right));
    }
}
