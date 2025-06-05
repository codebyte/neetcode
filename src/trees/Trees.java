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


    static int maxDia = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        diameterOfBinaryTreee(root);

        return maxDia;
    }

    public static int diameterOfBinaryTreee(TreeNode root) {
        if ((root.left == null) && (root.right == null)) {
            return 0;
        }

        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = diameterOfBinaryTreee(root.left) + 1;
        }
        if (root.right != null) {
            right = diameterOfBinaryTreee(root.right) + 1;
        }
        maxDia = Math.max(maxDia, left + right);

        return Math.max(left, right);
    }


    static boolean isBalanced = true;

    public int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        heightOfTree(root);
        System.out.println("ISBalanced : " + isBalanced);

        return maxDia;
    }

    public static int heightOfTreee(TreeNode root) {
        if ((isBalanced == false) || (root.left == null) && (root.right == null)) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = heightOfTreee(root.left) + 1;
        }
        if (root.right != null) {
            right = heightOfTreee(root.right) + 1;
        }

        if ((isBalanced) && (left != (right + 1)) || (right != (left + 1))) {
            isBalanced = false;
        }
        return Math.max(left, right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        boolean lVal = false;
        boolean rVal = false;
        if (root.left != null) {
            lVal = isSubtree(root.left, subRoot);
        }
        if (root.right != null) {
            rVal = isSubtree(root.right, subRoot);
        }

        if ((lVal == true) || (rVal == true)) {
            return true;
        }
        return false;
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null) && (q == null)) {
            return true;
        }

        if ((p != null) && (q == null)) {
            return false;
        }

        if ((p == null) && (q != null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    class Pair {
        boolean p;
        boolean q;

        Pair(boolean p, boolean q) {
            this.p = false;
            this.q = false;
        }
    }


    TreeNode lca = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if ((root.left != null) && (root.right != null)) {





        }


    }


    public static void main(String args[]) {
        TreeNode node = null;

        node = insert(node, 3);
        node = insert(node, 4);
        node = insert(node, 5);
        node = insert(node, 1);
        node = insert(node, 2);

        TreeNode node2 = null;
        node2 = insert(node2, 4);
        node2 = insert(node2, 1);
        node2 = insert(node2, 2);


        /*
        print(node);
        node = invertTree(node);

        System.out.println();
        print(node);

        if (node != null) {
            maxDepth(node, 1);
            System.out.println("Depth : " + max_depth);
        }

        if (node != null) {
            diameterOfBinaryTree(node);
            System.out.println("Max Diameter : " + maxDia);
        }

        if (node != null) {
            heightOfTreee(node);
            System.out.println("Is Balanced : " + isBalanced);
        }
         */


        if (node != null) {
            //isSameTree(node, node2);
            System.out.println("Same Tree : " + isSameTree(node, node2));
        }

        if (node != null) {
            //isSubtree(node, node2);
            System.out.println("Sub Tree : " + isSubtree(node, node2));
        }


    }
}
