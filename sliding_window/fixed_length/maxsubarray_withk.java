package sliding_window.fixed_length;

public class maxsubarray_withk {

    static int printsum(int arr[], int k) {
        int start = 0;
        int end = 0;
        int ans = 0;
        int sum = 0;

        while (end < arr.length) {
            sum += arr[end];

            if (end - start < k) {
                end++;
            }
            if (end - start >= k) {
                ans = Math.max(ans, sum);
                sum -= arr[start];
                start++;

            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 6, 7, 1, 1 };
        System.out.println(printsum(arr, 3));
    }
}
