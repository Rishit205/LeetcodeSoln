class Solution {
    public int solve(int nums[], int dp[], int idx ){

        if(idx>= nums.length){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }
        int pick  = nums[idx]+ solve(nums , dp , idx+2); // dp[n]will be used 
        int skip= solve(nums, dp , idx+1); // dp[n ] wil be used here 

        dp[idx]= Math.max(pick ,skip);

        return dp[idx];

    }
    public int rob(int[] nums) {

        int dp[]= new int[nums.length+1];

        Arrays.fill(dp,-1);

        return solve(nums, dp,0);
        
    }
}