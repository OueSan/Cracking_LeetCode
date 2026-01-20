class Solution:
    def maxProfit(self, inventory: List[int], orders: int) -> int:
        fn = lambda x: sum(max(0, xx - x) for xx in inventory) # balls sold 
    
        # last true binary search 
        lo, hi = 0, 10**9
        while lo < hi: 
            mid = lo + hi + 1 >> 1
            if fn(mid) >= orders: lo = mid
            else: hi = mid - 1
        
        ans = sum((x + lo + 1)*(x - lo)//2 for x in inventory if x > lo)
        return (ans - (fn(lo) - orders) * (lo + 1)) % 1_000_000_007