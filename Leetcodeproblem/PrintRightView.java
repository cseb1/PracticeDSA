package Leetcodeproblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintRightView {
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

    static TreeNode temp = null;

    public static ArrayList<Integer> findBottomRightValue(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) {
                    ans.add(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);

        System.out.println(findBottomRightValue(root));

        TreeNode n20 = new TreeNode(20);
        TreeNode n8 = new TreeNode(8);
        TreeNode n22 = new TreeNode(22);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n25 = new TreeNode(25);
        TreeNode n10 = new TreeNode(10);
        TreeNode n14 = new TreeNode(14);

        n20.left = n8;
        n20.right = n22;
        n8.left = n5;
        n8.right = n3;
        n22.right = n25;
        n3.left = n10;
        n3.right = n14;

        System.out.println(findBottomRightValue(n20));
    }
}
