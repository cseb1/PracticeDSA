package Leetcodeproblem;

public class MergeLL {
    // This is one type of Solution
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        ListNode an = null, bn = null;
        int idx = 0;
        // iterate until the list1 is not empty
        while (temp != null) {
            if (idx == a - 1) {
                an = temp;
            }
            if (idx == b + 1) {
                bn = temp;
            }
            temp = temp.next;
            idx++;
        }
        an.next = list2;
        getTail(list2).next = bn;
        return list1;
    }

    private static ListNode getTail(ListNode node) {
        while (node.next != null)
            node = node.next;
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        // ending of First list and head is l1

        ListNode l21 = new ListNode(100);
        ListNode l22 = new ListNode(101);
        ListNode l23 = new ListNode(102);
        l21.next = l22;
        l22.next = l23;

        // Ending of Second list and head is l21

        ListNode ans = mergeInBetween(l1, 3, 4, l21);

        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }
        System.out.println("null");

    }
}
