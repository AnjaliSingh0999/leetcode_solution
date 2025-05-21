class Solution {
    static final long MOD = 1_000_000_007;
 
    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static int minNonZeroProduct(int p) {
        long maxVal = (1L << p) - 1;                
        long secondMax = maxVal - 1;                
        long power = (1L << (p - 1)) - 1;           

        long powResult = modPow(secondMax, power, MOD);
        return (int)((powResult * (maxVal % MOD)) % MOD);
    }
}