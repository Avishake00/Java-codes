package LinkedList.singlyLinkedlist;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    static Node insertfirst(int data, Node head) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        return head;
    }

    static Node insertlast(int data, Node head) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(data);

        return head;
    }

    static Node insertpos(int i, Node data, Node head) {

        Node temp = head;
        int count = 1;
        if (i == 0) {
            return head = insertfirst(data.data, head);
        }

        while (count < i) {
            temp = temp.next;
            count++;

            if (temp.next == null) {
                return head = insertlast(data.data, head);
            }
        }
        data.next = temp.next;
        temp.next = data;

        return head;
    }

    static Node deletepos(int position, Node head) {

        Node temp = head;
        int count = 1;
        if (position == 0) {
            head = head.next;
            return head;
        }

        while (count < position) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            return head;
        }
        Node curr = temp.next;
        temp.next = curr.next;
        curr.next = null;
        return head;
    }

    static void print(Node head) {
        Node n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(10);
        Node head = node1;
        head = insertlast(20, head);
        head = insertlast(30, head);

        Node temp = new Node(40);

        head = insertpos(3, temp, head);

        head = deletepos(3, head);

        print(head);

    }
}
