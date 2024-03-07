public class CheckForChildreenSum {
    // https://www.geeksforgeeks.org/problem-of-the-day
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int key) {
            this.data = key;
            left = right = null;
        }
    }

    public static int isSumProperty(Node root) {
        // add your code here
        // Base case: If the tree is empty or it's a leaf node,
        // then it satisfies the property.
        if (root == null || (root.left == null && root.right == null))
            return 1;

        int left_data = 0, right_data = 0;

        // If left child is not null, then get its data
        if (root.left != null)
            left_data = root.left.data;

        // If right child is not null, then get its data
        if (root.right != null)
            right_data = root.right.data;

        // Check current node's value with the sum of left and right children
        // And recursively check for left and right subtrees
        if ((root.data == left_data + right_data)
                && (isSumProperty(root.left) != 0)
                && (isSumProperty(root.right) != 0))
            return 1;
        else
            return 0;

    }

    public static void main(String[] args) {
        Node r35 = new Node(35);
        Node r20 = new Node(20);
        Node r11 = new Node(15);
        Node r15 = new Node(15);
        Node r5 = new Node(5);
        Node r10 = new Node(10);
        Node r52 = new Node(5);

        r35.left = r20;
        r35.right = r11;
        r20.left = r15;
        r20.right = r5;
        r11.left = r10;
        r11.right = r52;

        System.out.println(isSumProperty(r35));
    }
}
