class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long total = (long) m * k;
        if (total > bloomDay.length) return -1;

        int low = 1;
        int high = 0;
        for (int day : bloomDay) {
            high = Math.max(high, day);
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int currentDay) {
        int bouquets = 0;
        int flowers = 0;

        for (int day : bloomDay) {
            if (day <= currentDay) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }

            if (bouquets >= m) return true;
        }

        return false;
    }
}
