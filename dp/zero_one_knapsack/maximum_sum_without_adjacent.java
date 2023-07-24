package dp.zero_one_knapsack;

// after space optimization
public class maximum_sum_without_adjacent {
    public static void main(String[] args) {
        int arr[] = { 5, 5, 10, 100, 10, 5 };
        int n = arr.length;

        int pick = 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int i = 0; i < n; i++) {
            pick = arr[i];
            if (i > 1) {
                pick += prev2;
            }
            int notpick = 0 + prev1;
            int curr = Math.max(pick, notpick);
            prev2 = prev1;
            prev1 = curr;
        }
        System.out.println(prev1);
    }

}

// tabulation
// public int FindMaxSum(int arr[], int n)
// {
// int dp[]= new int[n+1];
// for(int i=0;i<=n;i++){
// dp[i]=-1;
// }
// dp[0]=arr[0];
// int pick=0;
// for(int i=1;i<n;i++){
// pick= arr[i];
// if(i>1){
// pick+=dp[i-2];
// }
// int notpick=0+dp[i-1];
// dp[i]=Math.max(pick,notpick);

// }
// return dp[n-1];
// }

// recursion
// static int loot(int index,int arr[]){
// if(index==0)
// return arr[index];

// if(index<0)
// return 0;

// int pick= arr[index]+loot(index-2,arr);
// int notpick=0+loot(index-1,arr);

// return Math.max(pick,notpick);
// }

// memoization

// static int loot(int index,int arr[],int dp[]){
// if(index==0)
// return arr[index];

// if(index<0)
// return 0;

// if(dp[index]!=-1)
// return dp[index];

// int pick= arr[index]+loot(index-2,arr,dp);
// int notpick=0+loot(index-1,arr,dp);

// return dp[index]=Math.max(pick,notpick);
// }