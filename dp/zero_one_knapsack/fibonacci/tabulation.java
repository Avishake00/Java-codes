package dp.zero_one_knapsack.fibonacci;

public class tabulation {
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];

        // base case
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[n]);
    }

}
