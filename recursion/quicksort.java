package recursion;

public class quicksort {

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int arr[], int start, int end) {
        int count = 0;

        int pivot = arr[start];

        for (int i = start + 1; i <= end; i++) {
            if (pivot > arr[i])
                count++;
        }

        int pivotidx = start + count;

        swap(arr, start, pivotidx);
        int i = start;
        int j = end;

        while (i < pivotidx && j > pivotidx) {
            while (arr[i] < arr[pivotidx]) {
                i++;
            }

            while (arr[j] > arr[pivotidx]) {
                j--;
            }

            if (i < pivotidx && j > pivotidx) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    i++;
                    j--;
                }
            }
        }

        return pivotidx;

    }

    static void quick(int arr[], int start, int end) {

        if (start >= end) {
            return;
        }

        int p = partition(arr, start, end);

        quick(arr, start, p - 1);
        quick(arr, p + 1, end);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 5, 1, 2 };
        int n = arr.length;

        quick(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }

}
