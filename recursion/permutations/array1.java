package recursion.permutations;

import java.util.ArrayList;

public class array1 {

    static void permutation(int n, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, int arr[],
            boolean freq[]) {

        if (list.size() == n) {
            System.out.println(list);
            // ans.add(list) //if wants to return
            return;
        }

        for (int i = 0; i < n; i++) {

            // ith element is not pick then it is false now so after pick it will be false
            if (!freq[i]) {
                freq[i] = true;

                list.add(arr[i]);
                permutation(n, ans, list, arr, freq);
                list.remove(list.size() - 1);
                freq[i] = false;

            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int n = arr.length;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean freq[] = new boolean[n];
        permutation(n, ans, list, arr, freq);

        // return ans; //for platforms

    }

}
