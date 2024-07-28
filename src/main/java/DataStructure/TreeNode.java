package DataStructure;

public class TreeNode {
    public int val;
    public TreeNode left; // use recursion here, left is also a node
    public TreeNode right;
    public TreeNode(int x) { // a constructor, initialize the TreeNode when instance of TreeNode is created
        this.val = x;
    }
//
    public TreeNode() {}

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        return String.valueOf(val);
    }
}
