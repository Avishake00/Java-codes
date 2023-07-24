package recursion.permutations;

import java.util.*;

public class String2 {
    static Set<String> printedSet = new HashSet<>();

    static void permutation(int index, int n, char[] arr) {
        String Permutation = String.valueOf(arr); // to check if the string is presented in set or not
        if (!printedSet.contains(Permutation)) {
            System.out.println(Permutation);
            printedSet.add(Permutation); // add in set to get the non repeated strings
        }

        for (int i = index; i < n; i++) {
            // to get lexicographically (order wise first A then B then C)
            if (!shouldSwap(arr, index, i)) {
                continue;
            }

            swap(arr, i, index);
            Arrays.sort(arr, index + 1, n);
            permutation(index + 1, n, arr);
            swap(arr, i, index);
            Arrays.sort(arr, index + 1, n);
        }
    }

    static boolean shouldSwap(char[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] == arr[end]) {
                return false;
            }
        }
        return true;
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String s = "ABB";
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // Sort the array before generating permutations to get order wise
        permutation(0, n, arr);
    }

}
