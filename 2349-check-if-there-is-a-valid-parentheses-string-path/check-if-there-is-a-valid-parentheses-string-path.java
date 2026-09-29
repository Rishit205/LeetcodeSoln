import java.util.Arrays;

class Solution {

    public boolean solve(char[][] grid, int x, int y, int count, int[][][] dp) {

        if (count < 0) {
            return false;
        }
        if (grid[x][y] == '(') {
            count++;
        } else {
            count--;
        }

        if (count < 0) {
            return false;
        }

        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return count == 0;
        }

        if (dp[x][y][count] != -1) {
            return dp[x][y][count] == 1;
        }

        boolean down = false;
        boolean right = false;

        if (x + 1 < grid.length) {
            down = solve(grid, x + 1, y, count, dp);
        }

        if (y + 1 < grid[0].length) {
            right = solve(grid, x, y + 1, count, dp);
        }

        boolean ans = down || right;

        dp[x][y][count] = ans ? 1 : 0;

        return ans;
    }

    public boolean hasValidPath(char[][] grid) {

        int a = grid.length;
        int b = grid[0].length;

        if ((a + b - 1) % 2 != 0) {
            return false;
        }

        if (grid[0][0] == ')') {
            return false;
        }

        int[][][] dp = new int[a][b][a + b + 1];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(grid, 0, 0, 0, dp);
    }
}