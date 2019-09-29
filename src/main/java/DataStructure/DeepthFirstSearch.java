package DataStructure;

public class DeepthFirstSearch {

    public static void main(String[] args) {
        DeepthFirstSearch test = new DeepthFirstSearch();
        TreeNode root = new TreeNode(1); // the first node with value 1
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left; // connect the left node with the root node
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);
        left.left.left = new TreeNode(8);
        left.left.right = new TreeNode(9);
        left.right.right = new TreeNode(10);
        right.right.left = new TreeNode(11);
        /*
        *  the tree looks like:
        *             1
        *           /   \
        *          2     3
        *        /  \   /  \
        *       4    5 6    7
        *      / \    \    /
        *     8   9    10 11
        * */
        System.out.println("test result of pre-order DFS");
        test.preOrder(root);

        System.out.println("test result of in-order DFS");
        test.inOrder(root);

        System.out.println("test result of post-order DFS");
        test.postOrder(root);
    }

    public void preOrder(TreeNode node){// the input is first node, start with the root node
        if(node != null){
            System.out.println(node);
        } else {
            return; // return means go back to previous deepth
        }

        if(node.left != null) preOrder(node.left); // use recursion here
        if(node.right != null) preOrder(node.right);
    }

    public void inOrder(TreeNode node){
        if(node.left != null) inOrder(node.left);
        if(node != null){
            System.out.println(node);
        }else{
            return;
        }
        if(node.right!=null) inOrder(node.right);
    }

    public void postOrder(TreeNode node){
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        if(node != null){
            System.out.println(node);
        }else{
            return;
        }
    }
}
