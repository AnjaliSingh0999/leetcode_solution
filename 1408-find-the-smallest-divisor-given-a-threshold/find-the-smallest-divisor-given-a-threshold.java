class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = getMax(nums);
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (computeSum(nums, mid) <= threshold) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }

    private int computeSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // equivalent to Math.ceil(num * 1.0 / divisor)
        }
        return sum;
    }
}
