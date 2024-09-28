package DataStructure;

import java.util.ArrayList;
import java.util.LinkedList;

public class SerializeBinaryTree {
    // Encodes a tree to a single string.
    // Serialize the tree to a string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    // Helper function for pre-order traversal
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,"); // Use '#' to represent null
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);  // Serialize left subtree
        serializeHelper(root.right, sb); // Serialize right subtree
    }

    // Deserialize the string back to a tree
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = {0}; // Use an array to keep track of the current index
        return deserializeHelper(nodes, index);
    }

    // Helper function to build the tree recursively
    private TreeNode deserializeHelper(String[] nodes, int[] index) {
        if (nodes[index[0]].equals("#")) {
            index[0]++; // Move to the next element in the array
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        node.left = deserializeHelper(nodes, index);  // Recur for left subtree
        node.right = deserializeHelper(nodes, index); // Recur for right subtree

        return node;
    }

    public static void main(String[] args) {
        SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(serializeBinaryTree.serialize(root));

    }
}
