package dp.zero_one_knapsack;

// s1+s2=sum;
//s1-s2= diff;
// add both then we get s1= (sum+diff)/2
import java.util.Arrays;

public class countofSubset_k_diff {
    static int isSubsetSum(int n, int[] arr, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        // Base cases
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = { 0, 4, 0, 0, 13, 7, 10, 6, 4, 2, 7 };
        int n = arr.length;

        int sum = Arrays.stream(arr).sum();
        int diff = 3;

        int target = (sum + diff) / 2;

        int count = isSubsetSum(n, arr, target);

        System.out.println(count);
    }
}
