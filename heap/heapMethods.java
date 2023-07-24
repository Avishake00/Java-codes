package heap;

import java.util.ArrayList;

class Heap {
    public static ArrayList<Integer> heapList = new ArrayList<>();

    Heap() {

    }

    public static void swap(int i, int j) {
        int temp = heapList.get(i);
        heapList.set(i, heapList.get(j));
        heapList.set(j, temp);
    }

    public static void add(int data) {
        heapList.add(data);
        int x = heapList.size() - 1;
        int parent = (x - 1) / 2;

        while (heapList.get(parent) > heapList.get(x)) {
            swap(parent, x);
            x = parent;
            parent = (x - 1) / 2;
        }
    }

    public static int peek() {
        return heapList.get(0);
    }

    public static void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minindex = i;

        if (left < heapList.size() && heapList.get(left) < heapList.get(minindex))
            minindex = left;
        if (right < heapList.size() && heapList.get(right) < heapList.get(minindex))
            minindex = right;

        if (minindex != i) {
            swap(i, minindex);

            heapify(minindex);
        }
    }

    public static int remove() {
        int data = heapList.get(0);
        swap(0, heapList.size() - 1);
        heapList.remove(heapList.size() - 1);
        heapify(0);
        return data;
    }

    public static boolean isEmpty() {
        return heapList.size() == 0;
    }
}

public class heapMethods {

    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.add(2);
        hp.add(3);
        hp.add(4);
        hp.add(5);
        hp.add(10);
        hp.add(1);

        while (!hp.isEmpty()) {
            int data = hp.peek();
            hp.remove();
            System.out.println(data);
        }
    }
}
