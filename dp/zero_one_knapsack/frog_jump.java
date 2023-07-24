package dp.zero_one_knapsack;

public class frog_jump {

    static int jump(int n, int arr[], int dp[]) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int left = jump(n - 1, arr, dp) + Math.abs(arr[n] - arr[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = jump(n - 2, arr, dp) + Math.abs(arr[n] - arr[n - 2]);
        }

        return dp[n] = Math.min(right, left); // Return the minimum value
    }

    public static void main(String[] args) {
        int heights[] = { 10, 20, 30, 10 };
        int n = heights.length;
        int dp[] = new int[n + 1];
        dp[0] = 0;

        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(heights[i] - heights[i - 1]);

            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            int curr = Math.min(left, right);
            prev2 = prev;
            prev = curr;
        }

        System.out.println(prev);
    }

}
