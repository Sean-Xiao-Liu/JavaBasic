package LeetCode.Tree;

import DataStructure.TreeNode;

public class MaximumBinarTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null) return null;
        return construct(nums,0,nums.length);
    }

    private static TreeNode construct(int[] nums, int left, int right){
        if(left == right) return null;

        int index = maxIndex(nums,left,right); // get max index
        TreeNode root = new TreeNode(nums[index]); // start with the max number in the array
        root.left = construct(nums,left,index);
        root.right = construct(nums,index+1,right);
        return root;

    }


    // find the index of max number within array
    private static int maxIndex(int[] nums, int left, int right){
        int index = left;
        for(int i = left ; i < right ; i++){
            if(nums[i] > nums[index]){
                index = i;
            }
        }
        return index;
    }
}
