package dp.matrix_chain_multiplication;

public class MCM {
    static int solve(int arr[], int i, int j, int dp[][]) {

        if (i >= j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int temp = solve(arr, i, k, dp) + solve(arr, k + 1, j - 1, dp) + arr[i + 1] * arr[k] * arr[j];

            min = Math.min(min, temp);
        }

        return dp[i][j] = min;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 10 };
        int dp[][] = new int[1001][1001];

        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(arr, 1, arr.length - 1, dp));
    }

}

// recursive

// if (i >= j)
// return 0;

// int min = Integer.MAX_VALUE;

// for (int k = i; k < j; k++) {
// int temp = solve(arr, i, k, dp) + solve(arr, k + 1, j - 1, dp) + arr[i + 1] *
// arr[k] * arr[j];

// min = Math.min(min, temp);
// }

// return min;