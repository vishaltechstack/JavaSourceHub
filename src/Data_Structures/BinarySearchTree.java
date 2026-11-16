package Data_Structures;

public class BinarySearchTree {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;

    // 1. Insert a value into the BST: Average O(log n)
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode current, int value) {
        // Base case: Found an empty spot to attach the new leaf node
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }
        // Duplicate values are ignored
        return current;
    }

    // 2. Search for a value in the BST: Average O(log n)
    public boolean contains(int target) {
        return searchRecursive(root, target);
    }

    private boolean searchRecursive(TreeNode current, int target) {
        if (current == null) return false;
        if (target == current.value) return true;

        return target < current.value
                ? searchRecursive(current.left, target)
                : searchRecursive(current.right, target);
    }

    // 3. In-Order Traversal (Left -> Root -> Right): Prints elements in sorted order
    public void printInOrder() {
        System.out.print("BST Sorted (In-Order): ");
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(TreeNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.value + " ");
            inOrderRecursive(node.right);
        }
    }
}
