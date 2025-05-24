class Solution:
    def findLength(self, a: List[int], b: List[int]) -> int:
        return max(max(accumulate(zip(a[i:],b),lambda q,p:(q+1)*eq(*p),initial=0))
            for a,b in ((a,b),(b,a)) for i in range(len(a))
        )