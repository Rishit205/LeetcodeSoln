class Solution {

    public int findmin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                index = i;
            }
        }

        return index;
    }

    public int binarysearch(int[] nums, int target, int low, int high) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {

        int a = findmin(nums);

        // Search right sorted part
        int ans = binarysearch(nums, target, a, nums.length - 1);

        if (ans != -1) {
            return ans;
        }

        // Search left sorted part
        return binarysearch(nums, target, 0, a - 1);
    }
}