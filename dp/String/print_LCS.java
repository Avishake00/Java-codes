package dp.String;

public class print_LCS {

    static String lcs(int x, int y, String s1, String s2) {
        int dp[][] = new int[1001][1001];
        int n = x;
        int m = y;

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        String str = "";

        while (n > 0 && m > 0) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                str += s1.charAt(n - 1);
                n--;
                m--;
            } else {
                if (dp[n - 1][m] > dp[n][m - 1]) {
                    n--;
                } else {
                    m--;
                }
            }
        }
        return (str);

    }

    public static void main(String[] args) {
        String s1 = "agbcba";
        String s2 = "akbcba";
        System.out.println(lcs(s1.length(), s2.length(), s1, s2));
    }

}
