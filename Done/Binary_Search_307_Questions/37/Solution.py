class Solution:
    def smallestGoodBase(self, n: str) -> str:
        n = int(n)
        max_m = n.bit_length()  # log2(n) + 1
        
        for m in range(max_m, 1, -1):
            left, right = 2, int(n ** (1 / (m - 1))) + 1
            
            while left < right:
                mid = (left + right) // 2
                sum_m = (mid ** m - 1) // (mid - 1)
                
                if sum_m == n:
                    return str(mid)
                elif sum_m < n:
                    left = mid + 1
                else:
                    right = mid
        
        # If no smaller base found, return n-1 as the base
        return str(n - 1)