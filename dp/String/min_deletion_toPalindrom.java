package dp.String;

public class min_deletion_toPalindrom {
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

    static String reverse(String s) {
        String S = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            S += s.charAt(i);
        }

        return S;
    }

    public static void main(String[] args) {
        String s = "agbcba";
        String rev = reverse(s);
        System.out.println(s.length() - lcs(s.length(), s.length(), s, rev));
    }
}
