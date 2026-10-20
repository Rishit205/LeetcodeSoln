
import java.util.Arrays;

class Solution {

    public int solve(int idx, int[] nums, int[] dp, int fina) {

        if (idx >= fina) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int pick = nums[idx] + solve(idx + 2, nums, dp, fina);
        int npick = solve(idx + 1, nums, dp, fina);

        return dp[idx] = Math.max(pick, npick);
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        // Case 1: Exclude the last house
        int result1 = solve(0, nums, dp1, n - 1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        // Case 2: Exclude the first house
        int result2 = solve(1, nums, dp2, n);

        return Math.max(result1, result2);
    }
}
