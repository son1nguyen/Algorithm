package CtCI;

/**
 * Created by sonnguyen on 3/14/17.
 */
public class TreeUtil {

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);

        TreeNode walker = root;
        TreeNode insertPosition = null;
        while (walker != null) {
            insertPosition = walker;
            if (walker.value >= value) {
                walker = walker.left;
            } else if (walker.value < value) {
                walker = walker.right;
            }
        }

        if (insertPosition.value >= value) {
            insertPosition.left = new TreeNode(value);
        } else {
            insertPosition.right = new TreeNode(value);
        }

        return root;
    }

    public static TreeNode find(TreeNode root, int value) {
        if (root == null) return null;

        TreeNode walker = root;
        while (walker != null) {
            if (walker.value > value) {
                walker = walker.left;
            } else if (walker.value < value) {
                walker = walker.right;
            } else {
                return walker;
            }
        }

        return null;
    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.value + " ");
        printInorder(root.right);
    }
}
