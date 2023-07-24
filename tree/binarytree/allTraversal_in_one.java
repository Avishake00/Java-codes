package tree.binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class allTraversal_in_one {

    static class Pair {
        Node first;
        int second;

        public Pair(Node first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Structure of the
    // node of a binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void alltraversal(Node Root) {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(Root, 1));

        while (!st.isEmpty()) {
            Pair p = st.peek();
            if (p.second == 1) {

                st.peek().second++;
                pre.add(p.first.data);

                if (p.first.left != null) {
                    st.push(new Pair(p.first.left, 1));
                }
            }

            else if (p.second == 2) {
                st.peek().second++;
                in.add(p.first.data);

                if (p.first.right != null) {
                    st.push(new Pair(p.first.right, 1));
                }
            } else {
                post.add(p.first.data);
                st.pop();

            }
        }

        System.out.print("Preorder Traversal: ");
        for (int i : pre) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Printing Inorder
        System.out.print("Inorder Traversal: ");
        for (int i : in) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Printing Postorder
        System.out.print("Postorder Traversal: ");
        for (int i : post) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node Root = new Node(1);

        Root.left = new Node(2);
        Root.right = new Node(3);
        Root.left.left = new Node(4);
        Root.left.right = new Node(5);
        Root.right.left = new Node(6);
        Root.right.right = new Node(7);

        alltraversal(Root);

    }

}
