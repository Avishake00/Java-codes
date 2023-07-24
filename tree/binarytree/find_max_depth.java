package tree.binarytree;

import java.util.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class find_max_depth {

    static int depth(Node root) {
        if (root == null)
            return 0;

        int l = depth(root.left);
        int r = depth(root.right);
        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        Node Root = new Node(1);

        Root.left = new Node(2);
        Root.right = new Node(3);
        Root.left.left = new Node(4);
        Root.left.right = new Node(5);
        Root.right.left = new Node(6);
        Root.right.right = new Node(7);

        System.out.println(depth(Root));
    }
}
