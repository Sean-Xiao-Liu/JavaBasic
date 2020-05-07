package LeetCode;

public class SearchInBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null || val == root.val) return root;

        // will lead to a NullPointerException in IDE but works fine in LeetCode
        // use the property of BST
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);

    }


    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        SearchInBinarySearchTree test= new SearchInBinarySearchTree();
        TreeNode result = test.searchBST(root2,4);
        System.out.println(result.val);
    }
}
