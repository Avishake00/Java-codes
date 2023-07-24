package tree.binarytree;

import java.util.*;

public class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

    // DFS
    static void preorder(Node root) {
        if (root == null)
            return;

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);

        System.out.println(root.data);

    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    // BFS

    static void levelorder(Node root, List<int[]> list) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int n = q.size();
            int arr[] = new int[n];
            int index = 0;

            for (int i = 0; i < n; i++) {

                if (flag) {
                    index = i;
                } else {
                    index = n - i - 1;
                }

                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);
                arr[index] = q.poll().data;
            }

            list.add(arr);
            flag = !flag;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // preorder(root);

        // postorder(root);

        // inorder(root);

        List<int[]> list = new ArrayList<>();

        levelorder(root, list);

        System.out.println(list);
    }

}
