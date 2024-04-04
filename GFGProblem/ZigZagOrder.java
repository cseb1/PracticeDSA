package GFGProblem;

import java.util.*;

public class ZigZagOrder {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    ArrayList<Integer> zigZagTraversal(Node root) {
        // Add your code here.
        List<List<Integer>> temp = zigzag_Order(root);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < temp.get(i).size(); j++) {
                ans.add(temp.get(i).get(j));
            }
        }
        return ans;
    }

    List<List<Integer>> zigzag_Order(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            List<Integer> currentLevel = new ArrayList<Integer>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                if (!reverse) {
                    Node currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.data);

                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    Node currentNode = queue.pollLast();
                    currentLevel.add(currentNode.data);
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }

            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
