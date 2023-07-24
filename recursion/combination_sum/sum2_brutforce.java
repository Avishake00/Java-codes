package recursion.combination_sum;

//time--> O(2^n*n*logn)
//space-->O(n*x); x-no of patterns
import java.util.*;

public class sum2_brutforce {
    static Set<ArrayList<Integer>> set = new HashSet<>();

    static void findsum(int arr[], int n, int index, int target, ArrayList<Integer> list) {
        if (index == n) {
            if (target == 0) {
                if (!set.contains(list)) {
                    set.add(list);
                    System.out.println(list);
                }
            }
            return;
        }

        if (arr[index] <= target) {
            // pick
            list.add(arr[index]);
            findsum(arr, n, index + 1, target - arr[index], list); // just change the index to index+1 tp sum2
            // not pick
            list.remove(list.size() - 1); // remove last element of the list to see if there is any other combination
                                          // possible or not
        }
        findsum(arr, n, index + 1, target, list);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 2 };
        Arrays.sort(arr); // for combination sum2 cause we have to return the values in sorted order
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();

        findsum(arr, n, 0, 4, list);// start from the first if that no can be used again or not

    }
}
