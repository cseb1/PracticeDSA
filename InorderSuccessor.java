import java.util.ArrayList;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class InorderSuccessor {
    public static BinaryTreeNode<Integer> inorderSuccesor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
        // Write you code here.
        ArrayList<BinaryTreeNode<Integer>> order = new ArrayList<>();
        inorder(root, order);

        for (int i = 0; i < order.size(); i++) {
            if (order.get(i) == node) {
                if (i != order.size() - 1) {
                    return order.get(i + 1);
                } else {
                    return null;
                }
            }
        }
        return null;

    }

    public static void inorder(BinaryTreeNode<Integer> root, ArrayList<BinaryTreeNode<Integer>> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> r1 = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> r2 = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> r3 = new BinaryTreeNode<Integer>(3);
        BinaryTreeNode<Integer> r4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> r5 = new BinaryTreeNode<Integer>(5);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;

        BinaryTreeNode<Integer> node = inorderSuccesor(r1, r2);
        System.out.println(node.data);

    }
}
