public class AddLinkedList {
    static class ListNode<T> {

        public T data;
        public ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }
    }

    public static ListNode<Integer> addTwoLists(ListNode<Integer> first, ListNode<Integer> second) {
        // Write your code here.
        return addTwoNumbers(first, second);
    }

    private static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummy = new ListNode<Integer>(null);
        ListNode<Integer> temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode<Integer> node = new ListNode<Integer>(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
