class Solution {
   
    public int[] countBits(int n) {
    int[] res = new int[n + 1];
    for (int i = 0; i <= n; i++) {
        res[i] = Integer.bitCount(i); // built-in Java method
    }
    return res;
}

        
    
}