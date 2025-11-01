class Solution:
    def closestToTarget(self, arr: List[int], target: int) -> int:
        ans, seen = inf, set()
        for x in arr: 
            seen = {ss & x for ss in seen} | {x}
            ans = min(ans, min(abs(ss - target) for ss in seen))
        return ans 