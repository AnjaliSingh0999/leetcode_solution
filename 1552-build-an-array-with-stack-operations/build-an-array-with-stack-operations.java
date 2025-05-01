public class Solution{
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int targetIndex = 0;

        for (int num = 1; num <= n && targetIndex < target.length; num++) {
            result.add("Push");

            if (target[targetIndex] == num) {
                targetIndex++;
            } else {
                result.add("Pop");
            }
        }

        return result;
    }
}