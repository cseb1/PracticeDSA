package Leetcodeproblem;

import java.util.LinkedList;

import java.util.Queue;

public class EvenOddTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isEvenOddTree(TreeNode root) {
        // we use BFS algorithm
        // need a queue eith type pair{leve,node_value};
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    if (node.val % 2 == 0 || node.val <= prev) {
                        return false;
                    }
                } else {
                    if (node.val % 2 != 0 || node.val >= prev) {
                        return false;
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                prev = node.val;
            }
            flag = !flag;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n10 = new TreeNode(10);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n12 = new TreeNode(12);
        TreeNode n8 = new TreeNode(8);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);

        n1.left = n10;
        n1.right = n4;
        n10.left = n3;
        n4.left = n7;
        n4.right = n9;
        n3.left = n12;
        n3.right = n8;
        n7.left = n6;
        n9.right = n2;

        System.out.println(isEvenOddTree(n1));

    }
}
