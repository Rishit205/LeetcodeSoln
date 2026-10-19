class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int x = nums.length/2;

        int count =0;

        for(int i=0;i<nums.length ;i++){
            if(nums[i]==nums[x]){
                count++;
            }
        }

        return count ==1;
        
    }
}