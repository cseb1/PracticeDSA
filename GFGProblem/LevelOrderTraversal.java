package GFGProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// class Node {
//     int data;
//     Node left, right;

//     public Node(int item) {
//         data = item;
//         left = right = null;
//     }
// }

// class Solution {
//     // Function to return the level order traversal of a tree.
//     static int levelSize = 0;

//     static ArrayList<Integer> levelOrder(Node root) {
//         ArrayList<Integer> result = new ArrayList<>();
//         Queue<Node> q = new LinkedList<>();
//         q.offer(root);
//         levelSize = q.size();
//         while (!q.isEmpty()) {
//             for (int i = 0; i < levelSize; i++) {
//                 Node currentNode = q.poll();
//                 levelSize--;
//                 result.add(currentNode.data);
//                 if (currentNode.left != null) {
//                     q.offer(currentNode.left);
//                     levelSize++;
//                 }
//                 if (currentNode.right != null) {
//                     q.offer(currentNode.right);
//                     levelSize++;
//                 }
//             }
//         }
//         return result;
//     }
// }

public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int levelSize = 0;

    static ArrayList<Integer> levelOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        levelSize = q.size();
        while (!q.isEmpty()) {
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = q.poll();
                levelSize--;
                result.add(currentNode.data);
                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                    levelSize++;
                }
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                    levelSize++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.left = new Node(3);
        n1.right = new Node(2);
        System.out.println(levelOrder(n1));
    }
}
