package GFGProblem;

//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewTree {
    static class Node {
        int data;
        Node left, right;
        int hd;

        public Node(int key) {
            this.data = key;
            left = right = null;
            hd = Integer.MAX_VALUE;
        }
    }

    public static ArrayList<Integer> bottomView(Node root) {
        // we need one queue and map
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        // we can used TreeMap instead of HashMap
        // Bcz TreeMap contains sorted item and unique
        Map<Integer, Integer> map = new TreeMap<>();

        // root node horizontal distance is 0
        root.hd = 0;
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            map.put(node.hd, node.data);
            if (node.left != null) {
                node.left.hd = node.hd - 1;
                q.add(node.left);
            }

            if (node.right != null) {
                node.right.hd = node.hd + 1;
                q.add(node.right);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    public static void main(String[] args) {

        // Node n20 = new Node(20);
        // Node n8 = new Node(8);
        // Node n22 = new Node(22);
        // Node n5 = new Node(5);
        // Node n3 = new Node(3);
        // Node n25 = new Node(25);
        // Node n10 = new Node(10);
        // Node n14 = new Node(14);

        // n20.left = n8;
        // n20.right = n22;
        // n8.left = n5;
        // n8.right = n3;
        // n22.right = n25;
        // n3.left = n10;
        // n3.right = n14;
        // System.out.println(bottomView(n20));

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        System.out.println(bottomView(n1));

    }
}
