package Leetcodeproblem;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) { // if one element are present
            return false;
        }

        ListNode f = head;
        ListNode s = head;
        do {
            f = f.next.next;
            s = s.next;

            if (f == s) {
                return true;
            }
        } while (f != null && f.next != null);
        return false;
    }

    // lets find out the starting node position of the linked list cycle
    public static int findPos(ListNode head) {
        // if -1 return this function then this list are not have any cycle
        // otherwise its return the position
        if (head == null) {
            return -1;
        }
        if (head.next == null) { // if one element are present
            return -1;
        }

        ListNode f = head;
        ListNode s = head;
        do {
            f = f.next.next;
            s = s.next;

            if (f == s) {
                break;
            }
        } while (f != null && f.next != null);
        ListNode ptr = head;
        int pos = 0;
        while (ptr != s) {
            pos++;
            ptr = ptr.next;
            s = s.next;
        }
        if (ptr == s)
            return pos;

        return -1;
    }

    // write the code of find the middle node of any list
    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }

        if (f.next == null) {
            return s;
        } else {
            return s.next;
        }
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(0);
        l3.next.next.next = new ListNode(4);
        l3.next.next.next.next = l3.next;
        System.out.println(hasCycle(l3));
        System.out.println(findPos(l3));

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = l1;
        System.out.println(hasCycle(l1));
        System.out.println(findPos(l1));

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        ListNode ans = middleNode(n1);
        System.out.println(ans.val + "->" + ans.next.val);
    }
}
