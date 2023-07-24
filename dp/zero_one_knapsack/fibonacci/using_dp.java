package dp.zero_one_knapsack.fibonacci;

// algo --->
// first create a dp array of size n+1 to store the values that alrady got from the recursion
//fibo(n - 2, dp) + fibo(n - 1, dp); is the basic code for fibonacci
// then first out all the values as -1 and then check if the value is changed or not if changed then return that value

public class using_dp {

    static int fibo(int n, int dp[]) {

        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = fibo(n - 2, dp) + fibo(n - 1, dp);
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }

        System.out.println(fibo(n, dp));
    }
}
