package Leetcodeproblem;

//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/
import java.util.HashMap;
import java.util.Map;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        // we can create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> mp = new HashMap<>();
        mp.put(0, dummy);
        int prefixSum = 0;
        while (head != null) {
            prefixSum += head.val;
            if (mp.containsKey(prefixSum) == true) {
                // erase and linkup
                ListNode start = mp.get(prefixSum);
                ListNode temp = start;
                int pSum = prefixSum;
                while (temp != head) {
                    temp = temp.next;
                    pSum += temp.val;
                    if (temp != head)
                        mp.remove(pSum);

                }
                start.next = temp.next;
            } else {
                // put into the map
                mp.put(prefixSum, head);

            }
            head = head.next;
        }

        return dummy.next;
    }

    // print the List
    public void printList(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println(" null");
    }
}

public class RemoveConsecutiveSumfromLinkedList {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(-3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        s1.printList(l1);
        ListNode ans = s1.removeZeroSumSublists(l1);
        s1.printList(ans);

    }
}
