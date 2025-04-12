import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int result = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceBalls(position, m, mid)) {
                result = mid;
                left = mid + 1;  // try for bigger distance
            } else {
                right = mid - 1; // try for smaller distance
            }
        }

        return result;
    }

    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1; // first ball is placed
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
            }
            if (count >= m) return true;
        }

        return false;
    }
}
