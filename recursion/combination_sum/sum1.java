package recursion.combination_sum;

import java.util.*;

public class sum1 {
    static void findsum(int arr[], List<List<Integer>> ans, int index, int target, List<Integer> list) {
        if (index == arr.length) {
            if (target == 0) {
                System.out.println(list);
            }
            return;
        }

        // pick
        if (arr[index] <= target) {
            list.add(arr[index]);
            findsum(arr, ans, index, target - arr[index], list);
            list.remove(list.size() - 1); // remove last element of the list to see if there is any other combination
                                          // possible or not
        }
        findsum(arr, ans, index + 1, target, list);

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 7 };
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        findsum(arr, ans, 0, 7, list);// start from the first if that no can be used again or not

    }
}
