package sliding_window.fixed_length;

import java.util.ArrayList;

public class printFirstNeg {

    static void FirstNeg(int arr[], int k) {

        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        int n = arr.length;

        while (end < n) {
            // put all negative numbers in list
            if (arr[end] < 0) {
                list.add(arr[end]);
            }

            // if length of window<k then increase end
            if (end - start + 1 < k) {
                end++;
            }
            // if window meet his size the do the calculations
            else {

                if (list.size() == 0) { // no elements in list
                    System.out.println("0" + " ");

                } else { // print the first element of list and also arr[start]==list(0) then remove that
                         // cause it won't be
                         // needed further cause the window will be moved to the next value
                    System.out.println(list.get(0));
                    if (arr[start] == list.get(0)) {
                        list.remove(0);
                    }

                }

                // to move the window
                start++;
                end++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, -1, 7, -8, -15, 30, 16, 28 };
        FirstNeg(arr, 3);
    }

}
