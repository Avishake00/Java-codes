package recursion;

public class binarysearch {

    static boolean binserach(int arr[], int start, int end, int k) {
        int mid = start + (end - start) / 2;

        if (end < start) {
            return false;
        }
        if (arr[mid] == k) {
            return true;
        }
        if (arr[mid] < k) {
            return binserach(arr, mid + 1, end, k);
        }

        else {
            return binserach(arr, start, mid - 1, k);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5, 6, 8, 11 };
        System.out.println(binserach(arr, 0, 5, 8));
    }
}
