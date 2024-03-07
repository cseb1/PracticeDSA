package Leetcodeproblem;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNode {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void show(ListNode head) {
        if (head == null) {
            System.out.println("-->null");
        }
        ListNode ptr = head;
        while (ptr.next != null && ptr != null) {
            System.out.print(ptr.val + "-->");
            ptr = ptr.next;
        }
        System.out.println(ptr.val + "-->null");
    }

    static int size = 0;

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        if (n == 0) {
            return head;
        }
        ListNode ptr = head;
        while (ptr.next != null) {
            size++;
            ptr = ptr.next;
        }
        System.out.println(size);
        if (size + 1 == n) {
            return head.next;
        } else {
            ListNode node = head;
            ListNode prev = null;
            for (int i = 0; i <= size - n; i++) {
                prev = node;
                node = node.next;
            }
            if (node.next != null)
                prev.next = node.next;
            else {
                prev.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // ListNode l1 = new ListNode(1);
        // ListNode l2 = new ListNode(2);
        // ListNode l3 = new ListNode(3);
        // ListNode l4 = new ListNode(4);
        // ListNode l5 = new ListNode(5);
        // l1.next = l2;
        // l2.next = l3;
        // l3.next = l4;
        // l4.next = l5;
        // show(l1);
        // ListNode head = removeNthFromEnd(l1, 2);
        // show(head);

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        show(n1);
        ListNode node = removeNthFromEnd(n1, 2);
        show(node);
    }
}
