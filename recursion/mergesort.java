package recursion;

//time complexity-O(nlogn),space-O(n)
public class mergesort {

    static void conquer(int arr[], int start, int mid, int end) {
        int merge[] = new int[end - start + 1];// check this line
        int x = 0;
        int idx1 = start;
        int idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] < arr[idx2]) {
                merge[x++] = arr[idx1++];
            } else {
                merge[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merge[x++] = arr[idx1++];
        }

        while (idx2 <= end) {
            merge[x++] = arr[idx2++];
        }

        // check this one to put the merge array value to the origial arr
        for (int i = 0, j = start; i < merge.length; i++, j++) {
            arr[j] = merge[i];
        }

    }

    static void devider(int arr[], int start, int end) {
        int mid = start + (end - start) / 2;

        if (start >= end) {
            return;
        }

        devider(arr, start, mid);
        devider(arr, mid + 1, end);

        conquer(arr, start, mid, end);

    }

    public static void main(String[] args) {

        int arr[] = { 3, 1, 6, 4, 5 };
        int n = arr.length;
        devider(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }

}
