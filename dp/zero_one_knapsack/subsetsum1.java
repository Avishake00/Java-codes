package dp.zero_one_knapsack;

public class subsetsum1 {
    static boolean isSubsetSum(int n, int[] arr, int sum) {

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base cases
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 10 };
        int n = 3;
        int sum = 11;
        System.out.println(isSubsetSum(n, arr, sum));

    }
}
