package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // boundary case
        if(preorder.length == 0 && inorder.length == 0) return null;

        // the root will be the the first index of preorder array
        TreeNode root = new TreeNode(preorder[0]);

        if(preorder.length == 1) return root;


        // find the index of root val in the inorder array
        int index = 0;
        for(int val : inorder){
            if(val == root.val) break;
            index++;
        }

        if(preorder.length >= 1 && inorder.length >= 1 ){
            root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
            root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        }


        return root;
    }

    public static void main(String[] args) {
        /*
         *  the tree looks like:
         *             1
         *           /   \
         *          2     3
         *        /  \   /  \
         *       4    5 6    7
         *      / \    \    /
         *     8   9    10 11
         *
         * preorder traversal result [1, 2, 4, 8, 9, 5, 10, 3, 6, 7, 11]
         * inorder traversal result [8, 4, 9, 2, 5, 10, 1, 6, 3, 11, 7]
         * postorder traversal result [8, 9, 4, 10, 5, 2, 6, 11, 7, 3, 1]
         *
         *
         * */
        int[] preorder = {1, 2, 4, 8, 9, 5, 10, 3, 6, 7, 11};
        int[] inorder = {8, 4, 9, 2, 5, 10, 1, 6, 3, 11, 7};
        TreeNode result = buildTree(preorder,inorder);

        System.out.println(BinaryTreeInorderTraversal.inorderTraversal3(result));

    }
}
