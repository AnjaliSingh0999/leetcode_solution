class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrays = 1;
        int currSum = 0;

        for (int num : nums) {
            if (currSum + num > maxSum) {
                subarrays++;
                currSum = num;

                if (subarrays > k) return false;
            } else {
                currSum += num;
            }
        }

        return true;
    }
}
