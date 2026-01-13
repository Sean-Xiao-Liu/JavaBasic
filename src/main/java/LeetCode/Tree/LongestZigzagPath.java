package LeetCode.Tree;

import DataStructure.TreeNode;
import Utils.BinaryTreeConstructor;
import java.util.List;
import java.util.ArrayList;

public class LongestZigzagPath {
    // public int longestZigZag(TreeNode root) {
    //     int longestPath = 0;
    //     List<TreeNode> result = dfs(root);
    //     for(TreeNode node : result) {
    //         int path = Math.max(maxPath(node, 0), maxPath(node, 1));
    //         longestPath = Math.max(path, longestPath);
    //     }
    //     return longestPath;
    // }

    // public int maxPath(TreeNode root, int direction) {
    //     if(root == null) return 0;
    //     // 0 means left, 1 means right
    //     if(direction == 0) {
    //         return 1 + maxPath(root.left, 1);
    //     } else {
    //         return 1 + maxPath(root.right, 0);
    //     }
    // }

    // public List<TreeNode> dfs(TreeNode root) {
    //     if(root == null) return null;
    //     result.add(root);
    //     if(root.left != null) dfs(root.left);
    //     if(root.right != null) dfs(root.right);
    //     return result;
    // }

    // List<TreeNode> result = new ArrayList<>();

    public int maxLength=0;

    public void solve(TreeNode root,int dir,int currLength){
        if(root==null) return;
        // 0 means left, 1 means right
        maxLength=Math.max(maxLength,currLength);
        // 
        if(dir==1){
            solve(root.left,0,currLength+1);
            solve(root.right,1,1);
        }
        else{
            solve(root.right,1,currLength+1);
            solve(root.left,0,1);
        }
    }

    public int longestZigZag(TreeNode root) {
        solve(root,0,0);
        // solve(root,1,0);// no need to solve right side because the solve function already covers it
        return maxLength;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeConstructor.buildTree(new Integer[]{1,null,2,3,4,null,null,5,6,null,7,null,null,null,8});
        BinaryTreeConstructor.printTree(root);
        // System.out.println(new LongestZigzagPath().longestZigZag(root));
        // System.out.println(new LongestZigzagPath().maxPath(root, 0));
        // System.out.println(new LongestZigzagPath().maxPath(root, 1));
        // System.out.println(new LongestZigzagPath().dfs(root));
        System.out.println(new LongestZigzagPath().longestZigZag(root));
    }
}
