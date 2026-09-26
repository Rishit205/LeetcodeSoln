class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int x = fruits.length;

        int left = 0;
        int maxsize = 0;

        for (int right = 0; right < x; right++) {

            // Add the current fruit
            if (!h.containsKey(fruits[right])) {
                h.put(fruits[right], 1);
            } else {
                h.put(fruits[right], h.get(fruits[right]) + 1);
            }

            while (h.size() > 2) {

                h.put(fruits[left], h.get(fruits[left]) - 1);

                if (h.get(fruits[left]) == 0) {
                    h.remove(fruits[left]);
                }

                left++;
            }

            // Size of current window
            int size = right - left + 1;

            maxsize = Math.max(maxsize, size);
        }

        return maxsize;
    }
}