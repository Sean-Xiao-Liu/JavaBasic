package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    List result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {

            result.add(root.val);
            if (root.left != null) {
                preorderTraversal(root.left);
            }
            if (root.right != null) {
                preorderTraversal(root.right);
            }
        }
        return result;
    }
}
