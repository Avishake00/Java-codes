package sliding_window.veriable_length;

public class longest_subarray_withsumK {

    static int maxlength(int arr[], int sum) {
        int currsum = 0;
        int start = 0;
        int end = 0;
        int ans = 0;
        while (end < arr.length) {
            currsum += arr[end];
            if (currsum < sum) {
                end++;
            }
            if (currsum == sum) {
                ans = Math.max(ans, end - start + 1);
                end++;
            }
            if (currsum > sum) {
                currsum -= arr[start];
                start++;
                end++;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int sum = 0;

        System.out.println(maxlength(arr, sum));
    }

}
