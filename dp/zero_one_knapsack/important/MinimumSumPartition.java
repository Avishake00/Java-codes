package dp.zero_one_knapsack.important;

import java.util.*;

public class MinimumSumPartition {
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
        int arr[] = { 1, 6, 11, 5 };
        int n = arr.length;

        int sum = Arrays.stream(arr).sum();
        int min = Integer.MAX_VALUE;

        for (int i = sum / 2; i >= 0; i--) {
            if (isSubsetSum(n, arr, i)) {
                min = Math.min(min, sum - 2 * i);

            }
        }
        System.out.println(min);
    }
}

// recursive
// static boolean subsetSum(int arr[], int index, int target) {
// if (index < 0)
// return Math.abs(sum - 2 * currsum);
// // pick

// int include = diff(arr, index - 1, sum, currsum + arr[index]);

// int exlude = 0 + diff(arr, index - 1, sum, currsum);

// return Math.min(include, exlude);

// }
