package dp.zero_one_knapsack;

public class minimunNoofCoints {
    static int coins(int arr[], int target, int index) {

        if (target == 0) {
            return 0;
        }
        if (target < 0 || index < 0)
            return Integer.MAX_VALUE - 1;

        int includeCoin = coins(arr, target - arr[index], index) + 1;
        int excludeCoin = coins(arr, target, index - 1);

        return Math.min(includeCoin, excludeCoin);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int target = 7;

        System.out.println(coins(arr, target, arr.length - 1));

    }

}
