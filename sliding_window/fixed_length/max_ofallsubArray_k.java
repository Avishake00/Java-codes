package sliding_window.fixed_length;

public class max_ofallsubArray_k {

    static void printmax(int arr[], int k) {

        int start = 0;
        int end = 0;
        int max = arr[0];

        while (end < arr.length) {

            // operation
            max = Math.max(max, arr[end]);

            // increment the size of window
            if (end - start + 1 < k) {
                end++;
            }
            // when it reaches the size of k
            else {
                System.out.println(max);

                // if max element is the start of window then remove that from the window for
                // the next iteration
                if (arr[start] == max) {
                    max = arr[start + 1];
                }

                // increment the window size
                start++;
                end++;

            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        printmax(arr, 3);
    }

}
