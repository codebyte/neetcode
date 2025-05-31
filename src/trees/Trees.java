package trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Trees {

    public static TreeNode insert(TreeNode node, int ele) {
        if (node == null) {
            return new TreeNode(ele);
        }

        if (ele < node.val) {
            node.left = insert(node.left, ele);
        } else {
            node.right = insert(node.right, ele);
        }
        return node;
    }


    public static void print(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.val);
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode dLeft = invertTree(root.left);
        TreeNode dRight = invertTree(root.right);

        root.left = dRight;
        root.right = dLeft;

        return root;
    }

    static int max_depth = 0;
    public static void maxDepth(TreeNode root, int depth) {
        if ((root.left == null) && (root.right == null)) {
            max_depth = Math.max(max_depth, depth);
            return;
        }
        if (root.left != null) {
            maxDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            maxDepth(root.right, depth + 1);
        }
        return;
    }


    public static void main(String args[]) {
        TreeNode node = null;

        node = insert(node, 5);
        node = insert(node, 2);
        node = insert(node, 3);
        node = insert(node, 4);
        node = insert(node, 1);
        node = insert(node, 6);
        node = insert(node, 7);

        print(node);
        node = invertTree(node);

        System.out.println();
        print(node);

        if (node != null) {
            maxDepth(node, 1);
            System.out.println("Depth : " + max_depth);
        }


    }

}
