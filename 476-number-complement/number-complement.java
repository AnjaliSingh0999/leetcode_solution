public class Solution {
    public int findComplement(int num) {
        
        int bitLength = Integer.toBinaryString(num).length();

    
        int bitmask = (1 << bitLength) - 1;
 
        return num ^ bitmask;
    }
}
