package GFGProblem;

import java.util.Collections;
import java.util.LinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node sort(Node head) {
        // your code here, return the head of the sorted list
        LinkedList<Integer> arrayList = new LinkedList<>();
        Node current = head;
        while (current != null) {
            arrayList.add(current.data);
            current = current.next;
        }

        // Sort the ArrayList
        Collections.sort(arrayList);

        // Reconstruct the sorted linked list
        Node dummy = new Node(0);
        Node sortedList = dummy;
        for (int num : arrayList) {
            dummy.next = new Node(num);
            dummy = dummy.next;
        }

        return sortedList.next;
    }

    public void printList(Node head1) {
        Node head = head1;
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.data + "-->");
            head = head.next;
        }
        System.out.println("null");
    }
}

public class AlternatingSort {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(9);
        Node n3 = new Node(2);
        Node n4 = new Node(8);
        Node n5 = new Node(3);
        Node n6 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        Solution s1 = new Solution();
        System.out.println("Actual List is");
        s1.printList(n1);

        Node ans = s1.sort(n1);
        System.out.println("After Sorting Algorithm");
        s1.printList(ans);

    }
}
