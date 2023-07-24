package dp.String;

// tabulation---top down
public class long_com_subseq {
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
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        System.out.println(lcs(s1.length(), s2.length(), s1, s2));

    }
}

// memoization-> bottom up
// static int LCS(int x, int y, String s1, String s2,int dp[][]){
// if(x==0||y==0)
// return 0;

// if(dp[x][y]!=-1)
// return dp[x][y];

// if(s1.charAt(x-1)==s2.charAt(y-1)){
// dp[x][y]= lcs(x-1, y-1, s1, s2)+1;
// }

// else{dp[x][y]=Math.max(LCS(x, y-1, s1, s2,dp),LCS(x-1, y, s1, s2,dp));}

// return dp[x][y];
// }
// static int lcs(int x, int y, String s1, String s2)
// {
// int dp[][]= new int[1001][1001];

// for(int i=0;i<=x;i++){
// for(int j=0;j<=y;j++){
// dp[i][j]=-1;
// }
// }

// return LCS(x, y, s1, s2,dp);
// }

// recursive

// static int lcs(int x, int y, String s1, String s2)
// {
// if(x==0||y==0)
// return 0;

// if(s1.charAt(x-1)==s2.charAt(y-1)){
// return lcs(x-1, y-1, s1, s2)+1;
// }

// return Math.max(lcs(x, y-1, s1, s2),lcs(x-1, y, s1, s2));
// }
