package Leetcodeproblem;

import java.util.HashSet;
import java.util.Set;

public class kthDistance {
    static class Node {
        private int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }

        public int getData() {
            return data;
        }
    }

    static int count = 0;

    static int printKDistantfromLeaf(Node root, int k) {
        // Write your code here
        Set<Integer> ans = new HashSet<>();
        System.out.println(leftdistance);
        distance(root);
        if (leftdistance == k) {
            ans.add(root.data);
        }
        return ans.size();
    }

    static int leftdistance = 0;

    static private void distance(Node root) {
        if (root == null) {
            leftdistance = 0;
        }
        if (root.left == null && root.right == null) {
            leftdistance += 1;
        }
        distance(root.left);
        distance(root.right);

    }

    public static void main(String[] args) {
        Node r1 = new Node(1);
        Node r2 = new Node(2);
        Node r3 = new Node(3);
        Node r4 = new Node(4);
        Node r5 = new Node(5);
        Node r6 = new Node(6);
        Node r7 = new Node(7);
        Node r8 = new Node(8);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;
        r6.right = r8;

        System.out.println(printKDistantfromLeaf(r1, 2));

    }
}
