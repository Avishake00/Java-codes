package recursion.permutations;

import java.util.ArrayList;

// no extra space complexity needed // swapping method
public class array2 {

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void permutation(int arr[], int n, int i) {

        if (i == n) {
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                list2.add(arr[k]);
            }
            System.out.println(list2);
            return;
        }

        for (int k = i; k < n; k++) {
            swap(arr, i, k);
            permutation(arr, n, i + 1);
            swap(arr, i, k);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int n = arr.length;

        permutation(arr, n, 0);

    }
}
