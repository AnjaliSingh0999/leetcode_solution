class Solution {
    //2d matrix
    public boolean searchMatrix(int[][] matrix, int target) {
         int r= matrix.length;
         int c= matrix[0].length;

         int low=0;
         int high= r*c-1;
         while(low<=high){
            int mid= low+(high-low)/2;
            int i = mid/c;
            int j = mid%c;
            int value= matrix[i][j];

            if(value==target){
                return true;
            }else if(value<target){
                low= mid+1;
            } else{
                high=mid-1;
            }
         }
         return false;
        
    }
}