class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long mod = 1_000_000_007; // Result must be returned modulo 10^9 + 7

        // Calculate least common multiple of a and b
        long lcm = lcm(a, b);

        // Binary search bounds
        long low = 1;
        long high = (long) 1e18; // Large enough upper bound for worst-case scenario

        // Binary search to find the smallest number such that
        // count of magical numbers ≤ mid is at least n
        while (low <= high) {
            long mid = (low + high) / 2;

            // Count how many numbers ≤ mid are divisible by a or b
            long count = mid / a + mid / b - mid / lcm;

            if (count < n) {
                low = mid + 1; // Need more magical numbers → search higher
            } else {
                high = mid - 1; // Maybe too many → search lower
            }
        }

        // At the end of binary search, `low` is the nth magical number
        return (int) (low % mod);
    }

    // Helper to compute GCD (Greatest Common Divisor) using Euclidean algorithm
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper to compute LCM (Least Common Multiple) using GCD
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}