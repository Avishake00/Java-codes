package dp.zero_one_knapsack;

public class equal_partition_subset {

    static boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        boolean dp[][] = new boolean[n + 1][target + 1];

        for (int i = 0; i < n; i++) {

            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 5, 11, 5 };

        System.out.println(canPartition(nums));

    }

}
// -----------------recursive approach---------------
// static boolean isequal(int arr[],int index,int target){
// if(target==0)
// return true;

// if(target<0 || index<0)
// return false;

// boolean include= isequal(arr,index-1, target-arr[index]);
// boolean exclude=isequal(arr,index-1,target);

// return include||exclude;
// }
// public boolean canPartition(int[] nums) {
// int sum=0;
// for(int i=0;i<nums.length;i++){
// sum+=nums[i];
// }
// if(sum%2!=0)
// return false;
// int target=sum/2;

// return isequal(nums,nums.length-1,target);
// }
// }
