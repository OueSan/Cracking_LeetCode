class Solution:

    def __init__(self, n: int, blacklist: List[int]):
        blacklist.sort()
        self.jumps=[]
        for jump,e in enumerate(blacklist):
            self.jumps.append(e-jump)
        self.size=n-len(self.jumps)


    def pick(self) -> int:
        ran=random.randrange(self.size)
        jump=bisect.bisect_right(self.jumps,ran)
        return ran+jump


# Your Solution object will be instantiated and called as such:
# obj = Solution(n, blacklist)
# param_1 = obj.pick()