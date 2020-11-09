package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
            if(root.left != null) postorderTraversal(root.left);
            if(root.right != null) postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }
}
