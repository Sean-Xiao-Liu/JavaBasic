package LeetCode;

import DataStructure.TreeNode;

import javax.swing.plaf.IconUIResource;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length );
    }

    public TreeNode construct(int[] nums, int leftSide, int rightSide){
        if(leftSide == rightSide) return null;// the int[] is null, so the return should be null
        int maxIndex = maxIndex(nums,leftSide,rightSide);// find the max number in array
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums,leftSide,maxIndex);
        root.right = construct(nums, maxIndex+1, rightSide);
        return root;
    }

    public int maxIndex(int[] nums, int leftSide, int rightSide){
        int index = leftSide;
        for(int i = leftSide ; i < rightSide ; i++){
            if(nums[index] < nums[i]){
                index = i;
            }
        }
        return index;
    }
}
