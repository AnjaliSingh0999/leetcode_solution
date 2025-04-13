public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countLessEqual(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean countLessEqual(int[][] matrix, int mid, int k, int n) {
        int count = 0;
        int row = n - 1, col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }
        return count >= k;
    }
}
