package LeetCode;

//import DataStructure.TreeNode;

import DataStructure.TreeNode;

public class SubtreeOfAnotherTree {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        String stringS = preorder(s,true);
        String stringT = preorder(t,true);
        return stringS.indexOf(stringT) >= 0;
    }

    // use recursive method to distinguish the null value on the left and right null
    public static String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
    }



    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right =  new TreeNode(2);
//        s.left.right.left =  new TreeNode(0);


        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(isSubtree(s,t));
        System.out.println(preorder(s,true));
        System.out.println(preorder(t,true));
    }

}

//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int val){
//        this.val = val;
//    }
//}