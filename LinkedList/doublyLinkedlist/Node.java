package LinkedList.doublyLinkedlist;

public class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;

    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    static int length(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    static Node frontinsert(int data, Node head) {
        Node temp = new Node(data);

        temp.next = head;
        head.prev = temp;
        head = temp;

        return head;
    }

    static Node tailinsert(int data, Node head) {
        Node temp = head;
        Node last = new Node(data);

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = last;
        last.prev = temp;
        temp = last;

        return head;

    }

    static Node insertpos(int data, int pos, Node head, int length) {
        Node d = new Node(data);
        Node temp = head;
        int count = 1;
        if (pos == 0) {
            return frontinsert(data, head);
        }

        if (pos == length) {
            return tailinsert(data, head);
        }
        while (count < pos) {
            count++;
            temp = temp.next;
        }
        d.next = temp.next;
        temp.next.prev = d;
        temp.next = d;
        d.prev = temp;

        return head;

    }

    static Node deletepos(int pos, Node head, int len) {
        int count = 0;
        Node temp = head;

        if (pos == 0) {
            head = head.next;
            head.next.prev = head;
            return head;
        }

        if (pos == len - 1) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
            temp.prev = null;
            return head;
        }
        while (count < pos) {
            temp = temp.next;
            count++;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node head = node1;

        // print(head);

        head = tailinsert(20, head);

        head = tailinsert(30, head);

        head = insertpos(40, 3, head, length(head));
        // print(head);

        head = deletepos(0, head, length(head));

        print(head);

    }

}
