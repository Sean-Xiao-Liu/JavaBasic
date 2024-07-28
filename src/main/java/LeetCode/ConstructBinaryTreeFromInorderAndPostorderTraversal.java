package LeetCode;

import DataStructure.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        // boundary case, 如果两个array都为空， 则返回null
        if(inorder.length == 0 || postorder.length == 0) return null;



        // root is the last index of post order array
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        // if there is only one node in the array, it can be returned
        if(postorder.length == 1) return root;


        // iterate through the numbers in inorder array to find the index of root.val
        int index = 0;
        for(int val : inorder){
            if(val == root.val) break;
            index++;
        }


        // 左边的分支inorder 和 postorder array都截取 0 到 index 的部分
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        // 右边分值inorder 截取index 到最后，
        root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        buildTree(inorder,postorder);
    }
}

