package dp.String;

public class shortest_cmn_superString {

    static int lcs(int x, int y, String s1, String s2) {
        int dp[][] = new int[1001][1001];

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

        return dp[x][y];
    }

    public static void main(String[] args) {
        String s1 = "aggtab";
        String s2 = "gxtxayb";

        // shortest commom supersequence
        System.out.println(s1.length() + s2.length() - lcs(s1.length(), s2.length(), s1, s2));
    }
}
