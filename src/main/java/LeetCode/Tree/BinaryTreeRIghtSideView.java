package LeetCode.Tree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRIghtSideView {
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i< size ; i++){
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i == size - 1) answer.add(node.val);
            }
        }

        return answer;
    }


    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        // Base case: reached beyond leaf nodes
        if(curr == null){
            return;
        }
        // First node visited at this depth is the rightmost node (because we go right first)
        // If result.size() equals current depth, this is the first time we reach this level
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        // Traverse right subtree first so rightmost nodes are visited before left nodes
        // This ensures the first node at each depth is the visible one from the right side
        rightView(curr.right, result, currDepth + 1);
        // Traverse left subtree after right subtree to fill deeper levels if needed
        rightView(curr.left, result, currDepth + 1);
        
    }

}
