package dp.matrix_chain_multiplication;

public class no_partition_paliindrom {
    static boolean ispalindrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // optimize O(n)
    static int solve(String s, int i, int j, int dp[][]) {
        if (i >= j)
            return 0;

        if (ispalindrom(s, i, j))
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        for (int k = i; k < j; k++) {

            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = solve(s, i, k, dp);
                dp[i][k] = left;
            }

            if (dp[k + 1][j - 1] != -1) {
                right = dp[k + 1][j - 1];
            } else {
                right = solve(s, k + 1, j - 1, dp);
                dp[k + 1][j - 1] = right;
            }
            int temp = left + right + 1;

            min = Math.min(min, temp);

        }

        return dp[i][j] = min;

    }

    public static void main(String[] args) {
        String s = "geek";

        int dp[][] = new int[1001][1001];

        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(s, 0, s.length() - 1, dp));

    }
}

// memoization
// static int solve(String s, int i, int j, int dp[][]) {
// if (i >= j)
// return 0;

// if (ispalindrom(s, i, j))
// return 0;

// if (dp[i][j] != -1)
// return dp[i][j];

// int min = Integer.MAX_VALUE;

// for (int k = i; k < j; k++) {
// int temp = solve(s, i, k, dp) + solve(s, k + 1, j, dp) + 1;

// min = Math.min(min, temp);

// }

// return dp[i][j] = min;

// }

// recursive
// static int solve(String s, int i, int j) {
// if (i >= j)
// return 0;

// if (ispalindrom(s, i, j))
// return 0;

// int min = Integer.MAX_VALUE;

// for (int k = i; k < j; k++) {
// int temp = solve(s, i, k) + solve(s, k + 1, j ) + 1;

// min = Math.min(min, temp);

// }

// return min;

// }