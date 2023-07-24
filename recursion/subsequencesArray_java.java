package recursion;

import java.util.*;

//time-O(2^n);---->For every no there are certain extra numbers.
//space-O(n)--->depth of every funtion max goes to N

public class subsequencesArray_java {
    static void printseq(int i, ArrayList<Integer> list, int n, int arr[]) {
        if (i >= n) {
            System.out.println(list);
            return;
        }

        // to pick the elements
        list.add(arr[i]);
        printseq(i + 1, list, n, arr);

        list.remove(list.indexOf(arr[i]));

        // to not pick the elements
        printseq(i + 1, list, n, arr);

    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 1 };
        int n = 3;
        ArrayList<Integer> list = new ArrayList<Integer>();
        printseq(0, list, n - 1, arr);

    }
}
