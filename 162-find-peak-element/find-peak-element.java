class Solution {

    public int findPeak(int[] nums, int low, int high) {
    if (low == high) {
        return low;
    }

    int mid = low + (high - low) / 2;

    if (nums[mid] < nums[mid + 1]) {
        return findPeak(nums, mid + 1, high);
    } else {
        return findPeak(nums, low, mid);
    }
}

    public int findPeakElement(int[] nums) {
        int x =nums.length;
        int find = findPeak(nums,0,x-1);

        return find;

        
    }
}