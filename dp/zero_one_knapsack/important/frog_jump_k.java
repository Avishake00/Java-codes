package dp.zero_one_knapsack.important;

public class frog_jump_k {

    // static int jump(int arr[], int index, int k) {
    // if (index == 0)
    // return 0;

    // int minjump = Integer.MAX_VALUE;

    // for (int i = 1; i <= k; i++) // i should start from 1 cause its no use of
    // jump 0
    // {
    // if (index - i >= 0) {
    // int power = jump(arr, index - i, k) + Math.abs(arr[index] - arr[index - i]);
    // minjump = Math.min(minjump, power);
    // }
    // }

    // return minjump;
    // }

    // here space optimization is no needed cause we have to store prev k elements
    // to a list or some ds and for next iteration
    // we have to remove first one and then insert last one to shift one element

    public static void main(String[] args) {
        int arr[] = { 30, 10, 60, 10, 60, 50 };
        int n = arr.length;
        int k = 2;
        int dp[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int minjump = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j > 0) {
                    int power = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minjump = Math.min(minjump, power);
                    dp[i] = minjump;
                }

            }

        }
        System.out.println(dp[n - 1]);

    }

}
