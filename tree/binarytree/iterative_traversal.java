package tree.binarytree;

import java.util.*;

public class iterative_traversal {
    int data;
    iterative_traversal left;
    iterative_traversal right;

    iterative_traversal(int data) {
        this.data = data;
    }

    static void preorder(iterative_traversal root) {
        if (root == null)
            return;

        Stack<iterative_traversal> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {
            root = st.pop();
            System.out.println(root.data);

            // first see root ka right cause stack is lifo so on the time of printing left
            // will print fisrt
            if (root.right != null)
                st.push(root.right);

            if (root.left != null)
                st.push(root.left);

        }
    }

    static void inorder(iterative_traversal root) {
        if (root == null)
            return;

        Stack<iterative_traversal> st = new Stack<>();

        iterative_traversal node = root;
        while (true) {

            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty())
                    break;

                node = st.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }

    // with 2 stack
    static void postorder1(iterative_traversal root) {
        if (root == null)
            return;

        Stack<iterative_traversal> st1 = new Stack<>();
        Stack<iterative_traversal> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);

            if (root.left != null)
                st1.push(root.left);

            if (root.right != null)
                st1.push(root.right);

        }

        while (!st2.isEmpty()) {
            System.out.println(st2.pop().data);
        }
    }

    // with 1 stack

    static void postorder2(iterative_traversal root) {
        iterative_traversal curr = root;

        Stack<iterative_traversal> st = new Stack<>();
        iterative_traversal temp = null;

        while (!st.isEmpty() || curr != null) {
            // Add left values until it will null
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            // else go to root and print the right
            else {
                temp = st.peek().right;

                if (temp == null) {
                    temp = st.pop();
                    System.out.println(temp.data);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        System.out.println(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }

        }
    }

    public static void main(String[] args) {
        iterative_traversal root = new iterative_traversal(1);

        root.left = new iterative_traversal(2);
        root.right = new iterative_traversal(3);
        root.left.left = new iterative_traversal(4);
        root.left.right = new iterative_traversal(5);
        root.right.left = new iterative_traversal(6);
        root.right.right = new iterative_traversal(7);

        postorder2(root);

    }
}
