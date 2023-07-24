package tree.binarytree;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        right = left = null;
    }
}

public class max_path_sum {

    static int findmax(Node root, int[] max) {
        if (root == null)
            return 0;

        int lh = Math.max(0, findmax(root.left, max));
        int rh = Math.max(0, findmax(root.right, max));
        max[0] = Math.max(max[0], lh + rh + root.data);

        return root.data + Math.max(lh, rh);

    }

    public static void main(String[] args) {
        Node Root = new Node(1);

        Root.left = new Node(2);
        Root.right = new Node(3);
        Root.left.left = new Node(4);
        Root.left.right = new Node(5);
        Root.right.left = new Node(6);
        Root.right.right = new Node(7);

        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        findmax(Root, max);

        System.out.println(max[0]);
    }

}
