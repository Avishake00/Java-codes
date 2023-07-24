package recursion;

public class inversion_count {

    static int conquer(int arr[], int start, int mid, int end) {
        int merge[] = new int[end - start + 1];
        int x = 0;
        int idx1 = start;
        int idx2 = mid + 1;
        int swap = 0;

        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                merge[x++] = arr[idx1++];
            } else {
                merge[x++] = arr[idx2++];
                swap += mid - idx1 + 1; // Increment the swap count by the number of remaining elements in the left
                                        // subarray
                                        // cause if ine element of left side is greater than one element of right side
                                        // then it will
                                        // be greater than the other elements of right side cause both arrays are sorted
            }
        }

        while (idx1 <= mid) {
            merge[x++] = arr[idx1++];
        }

        while (idx2 <= end) {
            merge[x++] = arr[idx2++];
        }

        for (int i = 0, j = start; i < merge.length; i++, j++) {
            arr[j] = merge[i];
        }

        return swap;
    }

    static int devider(int arr[], int start, int end) {
        int mid = start + (end - start) / 2;
        int count = 0;

        if (start < end) {
            count += devider(arr, start, mid);
            count += devider(arr, mid + 1, end);
            count += conquer(arr, start, mid, end);
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 10, 10 };
        int n = arr.length;
        System.out.println(devider(arr, 0, n - 1));
    }
}
