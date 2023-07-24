package recursion.combination_sum;

import java.util.*;

public class sum2_optimized {
    static void findsum(int arr[], int n, int index, int target, ArrayList<Integer> list) {

        if (target == 0) {
            System.out.println(list);
            return;
        }

        // pick
        for (int i = index; i < n; i++) {
            if (arr[index] > target) // if suppose 3rd index gives op >target then no need to go for the 4th index
                break;
            if (arr[i - 1] == arr[i] && i > index) // if next index is similar then no need to go for that index
                continue; // that will reduce the extra time complexity of logn //i>index cause if it is
                          // first element then it will pick
                          // like- 1,1,1--> the first 1 will be picked

            list.add(arr[i]);
            findsum(arr, n, i + 1, target - arr[i], list);
            list.remove(list.size() - 1);

        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 2 };
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();

        findsum(arr, n, 1, 4, list);// start from the first if that no can be used again or not

    }
}
