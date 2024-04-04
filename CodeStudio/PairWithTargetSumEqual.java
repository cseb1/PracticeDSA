package CodeStudio;

import java.util.ArrayList;

public class PairWithTargetSumEqual {
    static class TreeNode<T> {
        public T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    public static boolean findTargetPair(TreeNode<Integer> root, int target) {

        // we find the inorder tarversal of the given tree
        // And then we check if the target sum are present in this array using Dp
        // recursion
        ArrayList<Integer> list = new ArrayList<>();
        findPreorder(root, list);
        System.out.println(list);
        return helper(list, target);

    }

    private static boolean helper(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    if (list.get(i) + list.get(j) == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void findPreorder(TreeNode<Integer> root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        if (root.left != null)
            findPreorder(root.left, list);
        if (root.right != null)
            findPreorder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode<Integer>(5);
        t1.left = new TreeNode<Integer>(2);
        t1.right = new TreeNode<Integer>(7);
        t1.left.left = new TreeNode<Integer>(1);
        t1.left.right = new TreeNode<Integer>(3);
        t1.right.left = new TreeNode<Integer>(6);
        t1.right.right = new TreeNode<Integer>(9);
        boolean ans = findTargetPair(t1, 20);
        System.out.println(ans);
    }
}
