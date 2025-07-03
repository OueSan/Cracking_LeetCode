class Solution:
    def nthMagicalNumber(self, n: int, a: int, b: int) -> int:
        mod = 10 ** 9 + 7
        lcm = a * b // gcd(a,b)
        def magic_count(x):
            return x // a + x // b - x // lcm
            
        l = 1
        r = n * min(a,b)

        while l < r:
            m = l + (r-l) // 2
            if magic_count(m) < n:
                l = m + 1
            else:
                r = m
        return l % mod