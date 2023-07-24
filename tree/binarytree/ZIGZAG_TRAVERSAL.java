package tree.binarytree;

import java.util.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
        right = left = null;
    }
}

public class ZIGZAG_TRAVERSAL {

    static ArrayList<Integer> reverse(ArrayList<Integer> list) {

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            ans.add(list.get(i));
        }

        return ans;
    }

    static List<List<Integer>> zigzag(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> list2 = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                Node node = q.poll();
                list2.add(node.data);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }

            if (flag == false) {
                Collections.reverse(list2);
            }

            list.add(list2);

            flag = !flag;
        }

        return list;
    }

    public static void main(String[] args) {
        Node Root = new Node(1);
        Root.left = new Node(2);
        Root.right = new Node(3);
        Root.left.left = new Node(4);
        Root.left.right = new Node(5);
        Root.right.left = new Node(6);
        Root.right.right = new Node(7);

        System.out.println(zigzag(Root));

    }
}
