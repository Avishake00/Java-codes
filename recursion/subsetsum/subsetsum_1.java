package recursion.subsetsum;

public class subsetsum_1 {

    static boolean isSum(int[] arr, int index, int target) {

        if (index == 0)
            return true;

        if (index == -1)
            return false;

        boolean include = isSum(arr, index - 1, target - arr[index]);
        boolean exclude = isSum(arr, index + 1, target + arr[index]);

        return include || exclude;

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5 };
        int targetSum = 7;
        int n = arr.length;

        boolean result = isSum(arr, n - 1, targetSum);

        System.out.println(result);
    }
}
