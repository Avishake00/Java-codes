package array;

public class find_neg_2D_array {
    static void countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int i = 0;
        int j = m - 1;
        while (i < n && j > 0) {
            int element = grid[i][j];
            if (element < 0) {
                System.out.println(element);
                j--;
                if (j < 0 && i < n - 1) {
                    j = m - 1;
                    i++;
                }
            } else {
                i++;
                j = m - 1;
            }

        }

    }

    public static void main(String[] args) {
        int arr[][] = { { 1, -1 }, { -1, -1 } };
        countNegatives(arr);

    }

}
