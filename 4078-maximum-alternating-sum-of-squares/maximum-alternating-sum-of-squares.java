import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        long sum = 0;

        // Sort by absolute value in ascending order
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) ->
            Long.compare(Math.abs((long) a), Math.abs((long) b))
        );

        // Subtract smaller squares, add larger squares
        for (int i = 0; i < n; i++) {
            long square = (long) arr[i] * arr[i];

            if (i < n / 2) {
                sum -= square;
            } else {
                sum += square;
            }
        }

        return sum;
    }
}