package Leetcodeproblem;

//https://leetcode.com/problems/palindrome-linked-list/description/
public class PalindromicLL {
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

    public static boolean isPalindrome(ListNode head) {
        // 1. find the mid
        // 2. reversing the second part after middle finding
        // 3. check the first halv and the second half are same or not?
        // 4. if same return true
        // 5. Otherwise return false; *** after returning we reverse the second half

        ListNode mid = getMid(head);
        ListNode headSecond = reverseList(mid);
        ListNode reverseHead = headSecond;

        // compare two individual list
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                // if it is not same then we break it;
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        reverseList(reverseHead);

        return head == null || headSecond == null;

    }

    private static ListNode getMid(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(isPalindrome(l1));
    }
}
