import java.util.*;

class Solution {
    public static void findSubset(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current)); 
            return;
        }

        
        current.add(arr[index]);
        findSubset(arr, index + 1, current, result);

        
        current.remove(current.size() - 1);
        findSubset(arr, index + 1, current, result);
    }

    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        findSubset(arr, 0, new ArrayList<>(), result);
        return result;
    }

     
}
