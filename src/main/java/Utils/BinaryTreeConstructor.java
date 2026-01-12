package Utils;

import DataStructure.TreeNode;

public class BinaryTreeConstructor {
    // Build tree from level-order array representation where null represents missing nodes
    public static TreeNode buildTree(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(levelOrder[0]);
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode current = queue.poll();
            
            // Process left child
            if (i < levelOrder.length) {
                if (levelOrder[i] != null) {
                    current.left = new TreeNode(levelOrder[i]);
                    queue.offer(current.left);
                }
                i++;
            }
            
            // Process right child
            if (i < levelOrder.length) {
                if (levelOrder[i] != null) {
                    current.right = new TreeNode(levelOrder[i]);
                    queue.offer(current.right);
                }
                i++;
            }
        }
        
        return root;
    }
    
    // Print tree structure in visual format
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        
        int height = getHeight(root);
        int maxWidth = (int) Math.pow(2, height + 1) * 2;
        
        java.util.List<java.util.List<String>> levels = new java.util.ArrayList<>();
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        java.util.Queue<Integer> positions = new java.util.LinkedList<>();
        
        queue.offer(root);
        positions.offer(maxWidth / 2);
        
        int level = 0;
        while (!queue.isEmpty() && level < height) {
            int levelSize = queue.size();
            java.util.List<String> currentLevel = new java.util.ArrayList<>();
            java.util.List<String> branches = new java.util.ArrayList<>();
            
            for (int i = 0; i < maxWidth; i++) {
                currentLevel.add(" ");
                branches.add(" ");
            }
            
            boolean hasNodes = false;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                int pos = positions.poll();
                
                if (node != null) {
                    hasNodes = true;
                    String val = String.valueOf(node.val);
                    if (pos >= 0 && pos < maxWidth) {
                        currentLevel.set(pos, val);
                    }
                    
                    int offset = Math.max(1, maxWidth / (int) Math.pow(2, level + 3));
                    
                    int leftPos = pos - offset;
                    int rightPos = pos + offset;
                    
                    if (node.left != null) {
                        if (leftPos - offset >= 0 && leftPos - offset < maxWidth) {
                            int branchPos = pos - offset / 2;
                            if (branchPos >= 0 && branchPos < maxWidth) {
                                branches.set(branchPos, "/");
                            }
                        }
                        queue.offer(node.left);
                        positions.offer(leftPos);
                    } else {
                        queue.offer(null);
                        positions.offer(leftPos);
                    }
                    
                    if (node.right != null) {
                        if (rightPos + offset < maxWidth) {
                            int branchPos = pos + offset / 2;
                            if (branchPos >= 0 && branchPos < maxWidth) {
                                branches.set(branchPos, "\\");
                            }
                        }
                        queue.offer(node.right);
                        positions.offer(rightPos);
                    } else {
                        queue.offer(null);
                        positions.offer(rightPos);
                    }
                } else {
                    queue.offer(null);
                    positions.offer(pos);
                    queue.offer(null);
                    positions.offer(pos);
                }
            }
            
            if (!hasNodes) break;
            
            levels.add(currentLevel);
            if (!branches.stream().allMatch(s -> s.equals(" "))) {
                levels.add(branches);
            }
            level++;
        }
        
        System.out.println("/*");
        System.out.println(" *  Tree structure:");
        for (java.util.List<String> levelLine : levels) {
            System.out.print(" *  ");
            for (String s : levelLine) {
                System.out.print(s);
            }
            System.out.println();
        }
        System.out.println(" */");
    }
    
    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        // Integer[] levelOrder = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        Integer[] levelOrder = {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};
        TreeNode root = buildTree(levelOrder);
        printTree(root);
    }
}
