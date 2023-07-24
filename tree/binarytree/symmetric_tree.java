package tree.binarytree;

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
        right = left = null;
    }
}

public class symmetric_tree {
    static boolean solve(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.data != right.data)
            return false;

        // left's right==right's left and left's left==right's right then it will be
        // symntric just like a mirror

        return solve(left.left, right.right) && solve(left.right, right.left);
    }

    static boolean isSymmetric(Node root) {
        if (root == null)
            return false;

        return solve(root.left, root.right);
    }

    public static void main(String[] args) {

        Node Root = new Node(1);
        Root.left = new Node(2);
        Root.right = new Node(2);
        Root.left.left = new Node(4);
        Root.left.right = new Node(5);
        Root.right.left = new Node(5);
        Root.right.right = new Node(4);

        System.out.println(isSymmetric(Root));

    }
}
