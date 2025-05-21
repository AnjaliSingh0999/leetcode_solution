class Solution {
    public static String largestNumber(int[] nums) {
        // Step 1: Convert int[] to String[]
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort using custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Edge case - if largest number is 0 (e.g., all zeros)
        if (arr[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the result string
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }

     
}
