import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static Queue<Integer> reverseElements(Queue<Integer> q, int k) {
        // Write your code here.
        Queue<Integer> ans = new LinkedList<>();
        Stack<Integer> ch = new Stack<>();
        for (int i = 0; i < k; i++) {
            int element = q.poll();
            ch.push(element);
        }
        while (!ch.isEmpty()) {
            ans.add(ch.peek());
            ch.pop();
        }
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        return ans;

    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(reverseElements(q, 3));
    }
}
