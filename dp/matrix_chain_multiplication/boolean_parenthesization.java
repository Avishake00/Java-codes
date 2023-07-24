package dp.matrix_chain_multiplication;

import java.util.HashMap;

// optimize walla code with the use of a mop 
// first store the variables i,j,istrue in map as a form of string then return that value if it is present in the map

public class boolean_parenthesization {
    static HashMap<String, Integer> map = new HashMap<>();

    static int Solve(String s, int i, int j, boolean isTrue) {
        String key = String.valueOf(i) + "" + String.valueOf(j) + "" + (isTrue ? "T" : "F");

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue) {
                map.put(key, s.charAt(i) == 'T' ? 1 : 0);
            } else {
                map.put(key, s.charAt(i) == 'F' ? 1 : 0);
            }

            return map.get(key);
        }

        int ans = 0;

        for (int k = i + 1; k < j; k += 2) {
            int LT = Solve(s, i, k - 1, true);
            int LF = Solve(s, i, k - 1, false);
            int RT = Solve(s, k + 1, j, true);
            int RF = Solve(s, k + 1, j, false);

            if (s.charAt(k) == '|') {
                if (isTrue)
                    ans += LT * RT + LT * RF + RT * LF;
                else
                    ans += LF * RF;
            }
            if (s.charAt(k) == '&') {
                if (isTrue)
                    ans += LT * RT;
                else
                    ans += LF * RF + LT * RF + RT * LF;
            }
            if (s.charAt(k) == '^') {
                if (isTrue)
                    ans += LT * RF + RT * LF;
                else
                    ans += LT * RT + LF * RF;
            }

        }

        map.put(key, ans);
        return map.get(key);
    }

    public static void main(String[] args) {
        String str = "T&T|F|F^F^T^T^T&T^F^T&F|F^F^F&F&F|F|F^F^T|T&T";
        int n = str.length();

        System.out.println(Solve(str, 0, n - 1, true));

    }

}

// recursive

// static int Solve(char[] X, int i, int j, boolean isTrue) {
// if (i > j)
// return 0;

// if (i == j) {
// if (isTrue && X[i] == 'T')
// return 1;
// else if (!isTrue && X[i] == 'F')
// return 1;
// else
// return 0;
// }

// int ans = 0;
// for (int k = i + 1; k < j; k += 2) {
// int l_T = Solve(X, i, k - 1, true);
// int l_F = Solve(X, i, k - 1, false);
// int r_T = Solve(X, k + 1, j, true);
// int r_F = Solve(X, k + 1, j, false);

// if (X[k] == '|') {
// if (isTrue == true)
// ans += l_T * r_T + l_T * r_F + l_F * r_T;
// else
// ans += l_F * r_F;
// } else if (X[k] == '&') {
// if (isTrue == true)
// ans += l_T * r_T;
// else
// ans += l_T * r_F + l_F * r_T + l_F * r_F;
// } else if (X[k] == '^') {
// if (isTrue == true)
// ans += l_T * r_F + l_F * r_T;
// else
// ans += l_T * r_T + l_F * r_F;
// }

// }

// return ans;
// }