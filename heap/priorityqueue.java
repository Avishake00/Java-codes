package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityqueue {
    static class student implements Comparable<student> {
        String name;
        int rank;

        student(String s, int rank) {
            this.name = s;
            this.rank = rank;
        }

        @Override
        public int compareTo(student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new student("a", 23));
        pq.add(new student("b", 5));
        pq.add(new student("c", 2));
        pq.add(new student("d", 28));
        pq.add(new student("e", 97));

        while (!pq.isEmpty()) {
            student st = pq.peek();
            pq.remove();
            System.out.println(st.name + " " + st.rank);
        }
    }
}
