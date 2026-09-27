
import java.util.Arrays;

class Solution {

    public int solve(String s, String t, int x, int y, int[][] dp) {

        if (y == t.length()) {
            return 1;
        }

        if (x == s.length()) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (s.charAt(x) == t.charAt(y)) {
            return dp[x][y] =
                solve(s, t, x + 1, y + 1, dp)
                + solve(s, t, x + 1, y, dp);
        } else {
            return dp[x][y] =
                solve(s, t, x + 1, y, dp);
        }
    }

    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, t, 0, 0, dp);
    }
}