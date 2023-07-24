
package dp.String;

public class minOperation {

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
        String s1 = "heap";
        String s2 = "pea";
        int x = s1.length();
        int y = s2.length();

        int LCS = lcs(x, y, s1, s2);

        int deletion = x - LCS;
        int intertion = y - LCS;

        System.out.println(intertion + deletion);

    }

}
