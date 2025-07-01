class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int start = 0, end = 0; 
        int cnt = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                cnt++;
            }

            while (cnt > k) {
                if (nums[start] == 0) {
                    cnt--;
                }
                start++;
            }

            res = Math.max(res, end - start + 1);
            end++;
        }

        return res;
    }
}

 