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

public class lowest_common_ansester {
    static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;

        if (right == null)
            return left;
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        Node Root = new Node(1);
        Root.left = new Node(2);
        Root.right = new Node(3);
        Root.left.left = new Node(4);
        Root.left.right = new Node(5);
        Root.right.left = new Node(6);
        Root.right.right = new Node(7);

        System.out.println(lowestCommonAncestor(Root, new Node(2), new Node(7)));

    }

}
